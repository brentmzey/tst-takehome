package io.brentzey.takehome.models.codec

import cats.effect.IO
import io.circe.{Decoder, Encoder}
import org.http4s.circe._

trait AutoCodec {

  implicit def circeJsonIntDecoder[A <: Int](implicit decoder: Decoder[A]) = jsonOf[IO, A]

  implicit def circeJsonIntEncoder[A <: Int](implicit encoder: Encoder[A]) = jsonEncoderOf[IO, A]

  implicit def circeJsonListDecoder[A <: List[_]](implicit decoder: Decoder[A]) = jsonOf[IO, A]

  implicit def circeJsonSeqDecoder[A <: Seq[_]](implicit decoder: Decoder[A]) = jsonOf[IO, A]

  implicit def circeJsonListEncoder[A <: List[_]](implicit encoder: Encoder[A]) = jsonEncoderOf[IO, A]

  implicit def circeJsonSeqEncoder[A <: Seq[_]](implicit encoder: Encoder[A]) = jsonEncoderOf[IO, A]

  implicit def circeJsonGenericDecoder[A](implicit decoder: Decoder[A]) = jsonOf[IO, A]

//  implicit def circeJsonEntityDecoder[A <: Entity[_]](implicit decoder: Decoder[A]) = jsonOf[IO, A]

//  implicit def circeJsonEntityEncoder[A <: Entity[_]](implicit encoder: Encoder[A]) = jsonEncoderOf[IO, A]

//  implicit def circeJsonEntityListDecoder[A <: List[Entity[_]]](implicit decoder: Decoder[A]) = jsonOf[IO, A]

//  implicit def circeJsonEntityListEncoder[A <: List[Entity[_]]](implicit encoder: Encoder[A]) = jsonEncoderOf[IO, A]

}