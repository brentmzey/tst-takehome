package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.CabinCodeConstants.CabinCode
import io.brentzey.takehome.constants.CoreConstants.RateCodeConstants.RateCode

/**
 * The CabinPrice class represents the price of a specific cabin with a given rate code.
 *
 * @param cabinCode The code of the cabin.
 * @param rateCode The code of the rate.
 * @param price The price of the rate.
 */
case class CabinPrice
(
  cabinCode: CabinCode,
  rateCode: RateCode,
  price: BigDecimal
)

object CabinPrice {
  def unapply(cabinPrice: CabinPrice): (CabinCode, RateCode, BigDecimal) = {
    (cabinPrice.cabinCode, cabinPrice.rateCode, cabinPrice.price)
  }

  def toBestGroupPrice(rate: Rate,
                       cabinPrice: CabinPrice): BestGroupPrice = {
    BestGroupPrice(
      cabinCode = cabinPrice.cabinCode,
      rateCode = cabinPrice.rateCode,
      price = cabinPrice.price,
      rateGroup = rate.rateGroup
    )
  }

  def toCabinCodeRateGroupTuple(rate: Rate,
                                cabinPrice: CabinPrice): CabinCodeRateGroupTuple = {
    CabinCodeRateGroupTuple(
      cabinCode = cabinPrice.cabinCode,
      rateGroup = rate.rateGroup
    )
  }
}