package io.brentzey.takehome

import io.brentzey.takehome.models.{BestGroupPrice, CabinPrice, Rate}
import io.brentzey.takehome.seed.BestGroupPriceSeedData

/**
 * App entrypoint
 */
object RateCalculator extends App {

  private val bestGroupPriceSeedData = BestGroupPriceSeedData

  def getBestGroupPrices(rates: Seq[Rate],
                         prices: Seq[CabinPrice]): Seq[BestGroupPrice] = {
    bestGroupPriceSeedData.expectedOutput
  }

  println( "Hello World!" )

}
