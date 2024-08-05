package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.PromotionConstants.PromotionCode

/**
 * The PromotionCombo class represents a combination of promotion codes.
 *
 * @param promotionCodes A sequence of PromotionCode objects representing the promotion codes in the combination.
 */
case class PromotionCombo
(
  promotionCodes: Seq[PromotionCode]
)
