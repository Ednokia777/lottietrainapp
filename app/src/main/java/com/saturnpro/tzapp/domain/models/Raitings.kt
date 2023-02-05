package com.saturnpro.tzapp

import com.google.gson.annotations.SerializedName
import com.saturnpro.tzapp.domain.models.classes.*


data class Raitings (

  @SerializedName("0" ) var _zero : ZeroClass? = ZeroClass(),
  @SerializedName("1" ) var _one : OneClass? = OneClass(),
  @SerializedName("2" ) var _two : TwoClass? = TwoClass(),
  @SerializedName("3" ) var _three : ThreeClass? = ThreeClass(),
  @SerializedName("4" ) var _four : FourClass? = FourClass(),
  @SerializedName("5" ) var _five : FiveClass? = FiveClass(),
  @SerializedName("6" ) var _six : SixClass? = SixClass(),
  @SerializedName("7" ) var _seven : SevenClass? = SevenClass(),
  @SerializedName("8" ) var _eight : EightClass? = EightClass()

)