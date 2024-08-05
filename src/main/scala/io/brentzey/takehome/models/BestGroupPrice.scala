package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.CabinCodeConstants.CabinCode
import io.brentzey.takehome.constants.CoreConstants.RateCodeConstants.RateCode
import io.brentzey.takehome.constants.CoreConstants.RateGroupConstants.RateGroup

/**
 * The BestGroupPrice class represents the best group price for a specific cabin code, rate code, and rate group.
 *
 * @param cabinCode The code of the cabin.
 * @param rateCode The code of the rate.
 * @param price The price of the rate.
 * @param rateGroup The group to which the rate belongs.
 */
case class BestGroupPrice
(
  cabinCode: CabinCode,
  rateCode: RateCode,
  price: BigDecimal,
  rateGroup: RateGroup
)

object BestGroupPrice {

  def toCabinCodeRateGroupTuple(rate: Rate,
                                bestGroupPrice: BestGroupPrice): CabinCodeRateGroupTuple = {
    CabinCodeRateGroupTuple(
      cabinCode = bestGroupPrice.cabinCode,
      rateGroup = rate.rateGroup
    )
  }
}