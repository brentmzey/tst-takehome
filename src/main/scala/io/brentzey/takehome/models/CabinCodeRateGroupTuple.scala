package io.brentzey.takehome.models

import io.brentzey.takehome.constants.CoreConstants.CabinCodeConstants.CabinCode
import io.brentzey.takehome.constants.CoreConstants.RateGroupConstants.RateGroup

/**
 * The CabinCodeRateGroupTuple class represents a tuple containing a cabin code and a rate group.
 * Sometimes comes in handy as a "bag" of relevant data entities when calculating best prices
 *
 * @param cabinCode The code of the cabin.
 * @param rateGroup The group to which the rate belongs.
 */
case class CabinCodeRateGroupTuple
(
  cabinCode: CabinCode,
  rateGroup: RateGroup
)
