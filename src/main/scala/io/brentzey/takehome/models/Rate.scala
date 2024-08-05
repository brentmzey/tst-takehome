package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.RateCodeConstants.RateCode
import io.brentzey.takehome.constants.CoreConstants.RateGroupConstants.RateGroup

/**
 * The Rate class represents a rate with a specific rate code and rate group.
 *
 * @param rateCode The code of the rate.
 * @param rateGroup The group to which the rate belongs.
 */
case class Rate
(
  rateCode: RateCode,
  rateGroup: RateGroup
)
