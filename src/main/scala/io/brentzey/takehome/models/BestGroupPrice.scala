package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.CabinCodeConstants.CabinCode
import io.brentzey.takehome.constants.CoreConstants.RateCodeConstants.RateCode
import io.brentzey.takehome.constants.CoreConstants.RateGroupConstants.RateGroup

case class BestGroupPrice
(
  cabinCode: CabinCode,
  rateCode: RateCode,
  price: BigDecimal,
  rateGroup: RateGroup
)
