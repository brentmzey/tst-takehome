package io.brentzey.takehome.groupprice

import io.brentzey.takehome.calculators.BestCabinGroupPriceCalculatorService
import io.brentzey.takehome.models.{BestGroupPrice, CabinPrice, Rate}
import io.brentzey.takehome.seed.BestGroupPriceSeedData
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * The BestGroupPriceSpec class contains test cases for verifying the functionality of the
 * BestCabinGroupPriceCalculator class.
 */
class BestGroupPriceSpec extends AnyFlatSpec with Matchers {

  private val cabinGroupPriceCalculator = BestCabinGroupPriceCalculatorService

  val bestGroupPriceData: BestGroupPriceSeedData.type = BestGroupPriceSeedData

  val rates: Seq[Rate] = bestGroupPriceData.inputRates
  val cabinPrices: Seq[CabinPrice] = bestGroupPriceData.inputCabinPrices
  val expectedOutput: Seq[BestGroupPrice] = bestGroupPriceData.expectedOutput

  it should "Verify expected best cabin prices are output from running the calculator" in {
    val actualOutput = cabinGroupPriceCalculator.getBestGroupPrices(rates, cabinPrices)
    println(s"Actual output: $actualOutput")
    assertResult(expectedOutput)(actualOutput)
  }

}
