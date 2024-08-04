package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.RateCodeConstants.RateCode
import io.brentzey.takehome.constants.CoreConstants.RateGroupConstants.RateGroup

case class Rate
(
  rateCode: RateCode,
  rateGroup: RateGroup
)
