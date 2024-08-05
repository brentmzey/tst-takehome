package io.brentzey.takehome.calculators

import io.brentzey.takehome.constants.CoreConstants.PromotionConstants.PromotionCode
import io.brentzey.takehome.logging.Logging
import io.brentzey.takehome.models.{Promotion, PromotionCombo}

/**
 * The PromotionComboCalculator class is responsible for calculating all valid combinations of promotions
 * and determining which promotions can be combined with a given promotion.
 */
class PromotionComboCalculator extends Logging {

  /**
   * Calculates all valid combinations of promotions.
   *
   * @param allPromotions A sequence of Promotion objects representing all available promotions.
   * @return A sequence of PromotionCombo objects representing all valid combinations of promotions.
   */
  def allCombinablePromotions(allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
    val allSubsets = allPromotions.toSet.subsets.toList
    val allValidCombos = allSubsets.filter { combo =>
      combo.nonEmpty && combo.forall { promo =>
        promo.notCombinableWith.forall(notCombinableCode => !combo.exists(_.code == notCombinableCode))
      }
    }

    val nonSubsetCombos = allValidCombos.filter { combo =>
      !allValidCombos.exists(otherCombo => otherCombo != combo && combo.subsetOf(otherCombo))
    }

    nonSubsetCombos.map { combo =>
      val orderedValues = combo.toList.sortBy(promo => getPromoCodeInt(Option(promo.code)))
      PromotionCombo(orderedValues.map(_.code))
    }.sortBy { combo => getPromoCodeInt(combo.promotionCodes.headOption) }
  }

  /**
   * Calculates all valid combinations of promotions that include a given promotion.
   *
   * @param promotionCode The code of the promotion to check combinations for.
   * @param allPromotions A sequence of Promotion objects representing all available promotions.
   * @return A sequence of PromotionCombo objects representing all valid combinations that include the given promotion.
   */
  def combinablePromotions(promotionCode: PromotionCode, allPromotions: Seq[Promotion]): Seq[PromotionCombo] = {
    val combinablePromos = allCombinablePromotions(allPromotions).filter(_.promotionCodes.contains(promotionCode))

    combinablePromos.map { combo =>
      val (head, tail) = combo.promotionCodes.partition(_ == promotionCode)
      val sortedTail = tail.sortBy(code => getPromoCodeInt(Some(code)))
      PromotionCombo(head ++ sortedTail)
    }
  }

  /**
   * Converts a promotion code to an integer for sorting purposes.
   *
   * @param promoCodeOpt An optional PromotionCode object.
   * @return An integer representing the promotion code.
   */
  private
  def getPromoCodeInt(promoCodeOpt: Option[PromotionCode]): Int = {
    promoCodeOpt.map(_.toString.replace("P", "").toInt).getOrElse(Int.MaxValue)
  }
}

object PromotionComboCalculator extends PromotionComboCalculator