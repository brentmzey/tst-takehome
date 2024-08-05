package io.brentzey.takehome.seed

import io.brentzey.takehome.constants.CoreConstants.PromotionConstants.{P1, P2, P3, P4, P5}
import io.brentzey.takehome.models.{Promotion, PromotionCombo}

trait PromotionCombinationsSeedData {

  val promo1 = Promotion(P1, Seq(P3))      // P1 is not combinable with P3
  val promo2 = Promotion(P2, Seq(P4, P5))  // P2 is not combinable with P4 and P5
  val promo3 = Promotion(P3, Seq(P1))      // P3 is not combinable with P1
  val promo4 = Promotion(P4, Seq(P2))      // P4 is not combinable with P2
  val promo5 = Promotion(P5, Seq(P2))      // P5 is not combinable with P2

  val allInputPromotions = Seq(promo1, promo2, promo3, promo4, promo5)

  val expectedOutputForAllCombos = Seq(
    PromotionCombo(Seq(P1, P2)), PromotionCombo(Seq(P1, P4, P5)),
    PromotionCombo(Seq(P2, P3)), PromotionCombo(Seq(P3, P4, P5))
  )

  val expectedOutputForP1 = Seq(
    PromotionCombo(Seq(P1, P2)), PromotionCombo(Seq(P1, P4, P5))
  )

  val expectedOutputForP2 = Seq(
    PromotionCombo(Seq(P2, P1)), PromotionCombo(Seq(P2, P3))
  )

  val expectedOutputForP3 = Seq(
    PromotionCombo(Seq(P3, P2)), PromotionCombo(Seq(P3, P4, P5))
  )

  val expectedOutputForP4 = Seq(
    PromotionCombo(Seq(P4, P1, P5)), PromotionCombo(Seq(P4, P3, P5))
  )

  val expectedOutputForP5 = Seq(
    PromotionCombo(Seq(P5, P1, P4)), PromotionCombo(Seq(P5, P3, P4))
  )

}

object PromotionCombinationsSeedData extends PromotionCombinationsSeedData