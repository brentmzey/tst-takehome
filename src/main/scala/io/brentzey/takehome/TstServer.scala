package io.brentzey.takehome

import cats.effect._
import io.brentzey.takehome.calculators.{BestCabinGroupPriceCalculatorService, PromotionComboCalculatorService}
import io.brentzey.takehome.logging.Logging
import io.brentzey.takehome.models.codec.{AutoCodec, TstCodec}
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.circe._
import org.http4s.blaze.server.BlazeServerBuilder
import io.circe.syntax._
import io.brentzey.takehome.models.codec.TstCodec._
import io.brentzey.takehome.models.{AllCombinablePromotionsInput, CombinablePromotionsInput, RateCalculationInput}
import org.http4s.server.Router

import scala.concurrent.ExecutionContext.global

object TstServer extends IOApp with Logging with AutoCodec {

  private lazy val cabinGroupPriceCalculatorService = BestCabinGroupPriceCalculatorService
  private lazy val promotionComboCalculatorService = PromotionComboCalculatorService

  private
  def rateCalculatorService: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case req @ POST -> Root / "rate-calculator" => {
      req.decode[RateCalculationInput] { input =>
        val bestCabinGroupPrices = cabinGroupPriceCalculatorService.getBestGroupPrices(input.rates, input.cabinPrices)
        Ok(bestCabinGroupPrices.asJson)
      }
    }
  }

  private
  def promotionalService: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case req @ POST -> Root / "all-combinable-promotions" => {
      req.decode[AllCombinablePromotionsInput] { input =>
        val allCombinablePromotions = promotionComboCalculatorService.allCombinablePromotions(input.allPromotions)
        Ok(allCombinablePromotions.asJson)
      }
    }
    case req @ POST -> Root / "combinable-promotions" => {
      req.decode[CombinablePromotionsInput] { input =>
        val combinablePromotions = promotionComboCalculatorService.combinablePromotions(input.promotionCode, input.allPromotions)
        Ok(combinablePromotions.asJson)
      }
    }
  }

  private
  val httpApp: HttpApp[IO] = Router(
    "/api" -> rateCalculatorService,
    "/api" -> promotionalService
  ).orNotFound

  def run(args: List[String]): IO[ExitCode] = {
    BlazeServerBuilder[IO](global)
      .bindHttp(8080, "0.0.0.0")
      .withHttpApp(httpApp)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
  }
}