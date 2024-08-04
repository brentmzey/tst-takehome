package io.brentzey.takehome.seed

import io.brentzey.takehome.constants.CoreConstants.CabinCodeConstants.{CA, CB}
import io.brentzey.takehome.constants.CoreConstants.RateCodeConstants.{M1, M2, S1, S2}
import io.brentzey.takehome.constants.CoreConstants.RateGroupConstants.{MILITARY, SENIOR}
import io.brentzey.takehome.models.{BestGroupPrice, CabinPrice, Rate}

trait BestGroupPriceSeedData {

  val inputRate1: Rate = Rate(M1, MILITARY)
  val inputRate2: Rate = Rate(M2, MILITARY)
  val inputRate3: Rate = Rate(S1, SENIOR)
  val inputRate4: Rate = Rate(S2, SENIOR)

  val inputRates: Seq[Rate] = Seq(inputRate1, inputRate2, inputRate3, inputRate4)

  val inputCabinPrice1 = CabinPrice(CA, M1, 200.00)
  val inputCabinPrice2 = CabinPrice(CA, M2, 250.00)
  val inputCabinPrice3 = CabinPrice(CA, S1, 225.00)
  val inputCabinPrice4 = CabinPrice(CA, S2, 260.00)
  val inputCabinPrice5 = CabinPrice(CB, M1, 230.00)
  val inputCabinPrice6 = CabinPrice(CB, M2, 260.00)
  val inputCabinPrice7 = CabinPrice(CB, S1, 245.00)
  val inputCabinPrice8 = CabinPrice(CB, S2, 270.00)

  val inputCabinPrices = Seq(
    inputCabinPrice1, inputCabinPrice2, inputCabinPrice3, inputCabinPrice4,
    inputCabinPrice5, inputCabinPrice6, inputCabinPrice7, inputCabinPrice8
  )

  /* -- */

  val expectedGroupPrice1 = BestGroupPrice(CA, M1, 200.00, MILITARY)
  val expectedGroupPrice2 = BestGroupPrice(CA, S1, 225.00, SENIOR)
  val expectedGroupPrice3 = BestGroupPrice(CB, M1, 230.00, MILITARY)
  val expectedGroupPrice4 = BestGroupPrice(CB, S1, 245.00, SENIOR)

  val expectedOutput = Seq(expectedGroupPrice1, expectedGroupPrice2, expectedGroupPrice3, expectedGroupPrice4)

}

object BestGroupPriceSeedData extends BestGroupPriceSeedData