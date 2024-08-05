package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.PromotionConstants.PromotionCode

/**
 * The Promotion class represents a promotion with a specific code and a list of promotion codes it is not combinable with.
 *
 * @param code The code of the promotion.
 * @param notCombinableWith A sequence of PromotionCode objects representing the promotion codes that cannot be combined with this promotion.
 */
case class Promotion
(
  code: PromotionCode,
  notCombinableWith: Seq[PromotionCode]
)
