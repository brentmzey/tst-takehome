package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.CabinCodeConstants.CabinCode
import io.brentzey.takehome.constants.CoreConstants.RateCodeConstants.RateCode

case class CabinPrice
(
  cabinCode: CabinCode,
  rateCode: RateCode,
  price: BigDecimal
)
