package io.brentzey.takehome.constants

import scala.util.Try

object CoreConstants {

  object RateCodeConstants extends Enumeration {
    type RateCode = Value
    val M1 = Value("M1")
    val M2 = Value("M2")
    val S1 = Value("S1")
    val S2 = Value("S2")

    def withNameOpt(s: String): Option[RateCode] = {
      Try(withName(s.toUpperCase)).toOption
    }
  }

  object RateGroupConstants extends Enumeration {
    type RateGroup = Value
    val MILITARY = Value("Military")
    val SENIOR = Value("Senior")

    def withNameOpt(s: String): Option[RateGroup] = {
      Try(withName(s.toUpperCase)).toOption
    }
  }

  object CabinCodeConstants extends Enumeration {
    type CabinCode = Value
    val CA = Value("CA")
    val CB = Value("CB")

    def withNameOpt(s: String): Option[CabinCode] = {
      Try(withName(s.toUpperCase)).toOption
    }
  }

}
