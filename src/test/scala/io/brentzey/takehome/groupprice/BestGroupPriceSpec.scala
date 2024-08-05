package io.brentzey.takehome.groupprice

import io.brentzey.takehome.calculators.BestCabinGroupPriceCalculator
import io.brentzey.takehome.seed.BestGroupPriceSeedData
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
 * The BestGroupPriceSpec class contains test cases for verifying the functionality of the
 * BestCabinGroupPriceCalculator class.
 */
class BestGroupPriceSpec extends AnyFlatSpec with Matchers {

  val bestGroupPriceData = BestGroupPriceSeedData

  val rates = bestGroupPriceData.inputRates
  val cabinPrices = bestGroupPriceData.inputCabinPrices
  val expectedOutput = bestGroupPriceData.expectedOutput

  it should "Verify expected best cabin prices are output from running the calculator" in {
    val actualOutput = BestCabinGroupPriceCalculator.getBestGroupPrices(rates, cabinPrices)
    println(s"Actual output: $actualOutput")
    assertResult(expectedOutput)(actualOutput)
  }

}
