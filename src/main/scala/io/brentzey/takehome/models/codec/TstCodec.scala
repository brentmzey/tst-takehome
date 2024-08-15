package io.brentzey.takehome.models.codec

import io.brentzey.takehome.constants.CoreConstants.{CabinCodeConstants, PromotionConstants, RateCodeConstants, RateGroupConstants}
import io.brentzey.takehome.models.{AllCombinablePromotionsInput, AllCombinablePromotionsResult, BestGroupPrice, CabinPrice, CombinablePromotionsInput, CombinablePromotionsResult, Promotion, PromotionCombo, Rate, RateCalculationInput, RateCalculationResult}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

trait TstCodec extends AutoCodec {

  // Entities
  implicit val rateDecoder: Decoder[Rate] = deriveDecoder[Rate]
  implicit val rateEncoder: Encoder[Rate] = deriveEncoder[Rate]
  implicit val bestGroupPriceDecoder: Decoder[BestGroupPrice] = deriveDecoder[BestGroupPrice]
  implicit val bestGroupPriceEncoder: Encoder[BestGroupPrice] = deriveEncoder[BestGroupPrice]
  implicit val promotionComboDecoder: Decoder[PromotionCombo] = deriveDecoder[PromotionCombo]
  implicit val promotionComboEncoder: Encoder[PromotionCombo] = deriveEncoder[PromotionCombo]
  implicit val cabinPriceDecoder: Decoder[CabinPrice] = deriveDecoder[CabinPrice]
  implicit val cabinPriceEncoder: Encoder[CabinPrice] = deriveEncoder[CabinPrice]
  implicit val promotionDecoder: Decoder[Promotion] = deriveDecoder[Promotion]
  implicit val promotionEncoder: Encoder[Promotion] = deriveEncoder[Promotion]

  // Codes
  implicit val rateCodeDecoder: Decoder[io.brentzey.takehome.constants.CoreConstants.RateCodeConstants.RateCode] = Decoder.decodeEnumeration(RateCodeConstants)
  implicit val rateCodeEncoder: Encoder[io.brentzey.takehome.constants.CoreConstants.RateCodeConstants.RateCode] = Encoder.encodeEnumeration(RateCodeConstants)
  implicit val rateGroupDecoder: Decoder[io.brentzey.takehome.constants.CoreConstants.RateGroupConstants.RateGroup] = Decoder.decodeEnumeration(RateGroupConstants)
  implicit val rateGroupEncoder: Encoder[io.brentzey.takehome.constants.CoreConstants.RateGroupConstants.RateGroup] = Encoder.encodeEnumeration(RateGroupConstants)
  implicit val cabinCodeDecoder: Decoder[io.brentzey.takehome.constants.CoreConstants.CabinCodeConstants.CabinCode] = Decoder.decodeEnumeration(CabinCodeConstants)
  implicit val cabinCodeEncoder: Encoder[io.brentzey.takehome.constants.CoreConstants.CabinCodeConstants.CabinCode] = Encoder.encodeEnumeration(CabinCodeConstants)
  implicit val promotionCodeDecoder: Decoder[io.brentzey.takehome.constants.CoreConstants.PromotionConstants.PromotionCode] = Decoder.decodeEnumeration(PromotionConstants)
  implicit val promotionCodeEncoder: Encoder[io.brentzey.takehome.constants.CoreConstants.PromotionConstants.PromotionCode] = Encoder.encodeEnumeration(PromotionConstants)

  implicit val rateCalculationInputDecoder: Decoder[RateCalculationInput] = deriveDecoder[RateCalculationInput]
  implicit val rateCalculationResultEncoder: Encoder[RateCalculationResult] = deriveEncoder[RateCalculationResult]

  implicit val allCombinablePromotionsDecoder: Decoder[AllCombinablePromotionsInput] = deriveDecoder[AllCombinablePromotionsInput]
  implicit val allCombinablePromotionsResultEncoder: Encoder[AllCombinablePromotionsResult] = deriveEncoder[AllCombinablePromotionsResult]
  implicit val combinablePromotionsDecoder: Decoder[CombinablePromotionsInput] = deriveDecoder[CombinablePromotionsInput]
  implicit val combinablePromotionsResultEncoder: Encoder[CombinablePromotionsResult] = deriveEncoder[CombinablePromotionsResult]

}

object TstCodec extends TstCodec