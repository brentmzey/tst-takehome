package io.brentzey.takehome

import io.brentzey.takehome.calculators.{BestCabinGroupPriceCalculatorService, PromotionComboCalculatorService}
import io.brentzey.takehome.logging.{Logging, Startup}
import io.brentzey.takehome.seed.{BestGroupPriceSeedData, PromotionCombinationsSeedData}

/**
 * The RateCalculator object serves as the entry point for the application.
 * It initializes the seed data and calculators, and logs the results of the calculations.
 */
object RateCalculator extends App with Logging with Startup {

  private val bestGroupPriceSeedData = BestGroupPriceSeedData
  private val promotionComboSeedData = PromotionCombinationsSeedData
  private val bestCabinGroupPriceCalulator = BestCabinGroupPriceCalculatorService
  private val promotionComboCalculator = PromotionComboCalculatorService

  protected val bestCabinGroupPrices = bestCabinGroupPriceCalulator
    .getBestGroupPrices(bestGroupPriceSeedData.inputRates, bestGroupPriceSeedData.inputCabinPrices)

  protected val allCombinablePromos = promotionComboCalculator
    .allCombinablePromotions(promotionComboSeedData.allInputPromotions)
  protected val p1AllCombinablePromos = promotionComboCalculator
    .combinablePromotions(promotionComboSeedData.promo1.code, promotionComboSeedData.allInputPromotions)

  logger.info(rateBootLogo)
  logger.info(s"Best cabin group prices actual: $bestCabinGroupPrices")
  logger.info(s"Best cabin group prices expected: ${bestGroupPriceSeedData.expectedOutput}")
  logger.info("/* -- */ ....................................................... /* -- */")
  logger.info(promoBootLogo)
  logger.info(s"All input Promotions: ${promotionComboSeedData.allInputPromotions}")
  logger.info(s"Expected output PromotionCombos: ${promotionComboSeedData.expectedOutputForAllCombos}")
  logger.info(s"All combos: $allCombinablePromos")
  logger.info(s"All combos given input P1: $p1AllCombinablePromos")
  logger.info(s"Expected combos given input P1: ${promotionComboSeedData.expectedOutputForP1}")
}
