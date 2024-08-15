package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.PromotionConstants.PromotionCode

case class RateCalculationInput(rates: Seq[Rate], cabinPrices: Seq[CabinPrice])
case class RateCalculationResult(bestCabinGroupPrices: Seq[BestGroupPrice])
case class AllCombinablePromotionsInput(allPromotions: Seq[Promotion])
case class AllCombinablePromotionsResult(allCombinablePromotions: Seq[PromotionCombo])
case class CombinablePromotionsInput(promotionCode: PromotionCode, allPromotions: Seq[Promotion])
case class CombinablePromotionsResult(combinablePromotions: Seq[PromotionCombo])
