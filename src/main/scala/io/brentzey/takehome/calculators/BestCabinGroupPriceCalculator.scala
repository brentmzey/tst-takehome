package io.brentzey.takehome.calculators

import io.brentzey.takehome.logging.Logging
import io.brentzey.takehome.models.{BestGroupPrice, CabinPrice, Rate}

/**
 * The BestCabinGroupPriceCalculator class is responsible for calculating the best group prices
 * for cabins based on the provided rates and cabin prices.
 */
trait BestCabinGroupPriceCalculator extends Logging {

  /**
   * Calculates the best group prices for cabins.
   *
   * @param rates  A list of Rate objects representing the rates.
   * @param prices A list of CabinPrice objects representing the cabin prices.
   * @return A list of BestGroupPrice objects representing the best group prices for cabins.
   */
  def getBestGroupPrices(rates: Seq[Rate],
                         prices: Seq[CabinPrice]): Seq[BestGroupPrice] = {
    val pricesGroupedByCabinCodeAndRateGroup = prices.groupBy { price =>
      val applicableRateGroups = rates.find(_.rateCode == price.rateCode).map(_.rateGroup)
      // finally group on the tuple
      ( price.cabinCode, applicableRateGroups )
    }

    // Calculate the best group prices by the groupings
    pricesGroupedByCabinCodeAndRateGroup.flatMap {
      case ((cabinCode, Some(rateGroup)), cabinPrices) =>
        cabinPrices.sortBy(_.price).headOption.map(cabinPrice =>
          BestGroupPrice(
            cabinCode = cabinCode,
            rateCode = cabinPrice.rateCode,
            price = cabinPrice.price,
            rateGroup = rateGroup
          )
        )
      case _ => None
    }.toSeq.sortBy(_.price)
  }

}

object BestCabinGroupPriceCalculator extends BestCabinGroupPriceCalculator