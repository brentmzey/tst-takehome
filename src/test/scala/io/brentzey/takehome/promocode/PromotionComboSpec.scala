package io.brentzey.takehome.promocode

import io.brentzey.takehome.calculators.PromotionComboCalculatorService
import io.brentzey.takehome.logging.Logging
import io.brentzey.takehome.seed.PromotionCombinationsSeedData
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * The PromotionComboSpec class contains test cases for verifying the functionality of the
 * PromotionComboCalculator class.
 */
class PromotionComboSpec extends AnyFlatSpec with Matchers with Logging {

  private val promotionComboData = PromotionCombinationsSeedData
  private val allInputPromotions = promotionComboData.allInputPromotions
  private val promotionComboCalculator = PromotionComboCalculatorService

  it should "Test allInputPromotions and give proper, expected output" in {
    val allCombosActualResult = promotionComboCalculator.allCombinablePromotions(allInputPromotions)
    assertResult(promotionComboData.expectedOutputForAllCombos)(allCombosActualResult)
  }

  it should "Test P1 promotion input and give proper, expected output" in {
    val p1CombosActualResult = promotionComboCalculator.combinablePromotions(promotionComboData.promo1.code, allInputPromotions)
    assertResult(promotionComboData.expectedOutputForP1)(p1CombosActualResult)
  }

  it should "Test P2 promotion input and give proper, expected output" in {
    val p2CombosActualResult = promotionComboCalculator.combinablePromotions(promotionComboData.promo2.code, allInputPromotions)
    assertResult(promotionComboData.expectedOutputForP2)(p2CombosActualResult)
  }

  it should "Test P3 promotion input and give proper, expected output" in {
    val p3CombosActualResult = promotionComboCalculator.combinablePromotions(promotionComboData.promo3.code, allInputPromotions)
    assertResult(promotionComboData.expectedOutputForP3)(p3CombosActualResult)
  }

  it should "Test P4 promotion input and give proper, expected output" in {
    val p4CombosActualResult = promotionComboCalculator.combinablePromotions(promotionComboData.promo4.code, allInputPromotions)
    assertResult(promotionComboData.expectedOutputForP4)(p4CombosActualResult)
  }

  it should "Test P5 promotion input and give proper, expected output" in {
    val p5CombosActualResult = promotionComboCalculator.combinablePromotions(promotionComboData.promo5.code, allInputPromotions)
    assertResult(promotionComboData.expectedOutputForP5)(p5CombosActualResult)
  }

}
