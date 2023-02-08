package com.saturnpro.tzapp.domain.models.archivo

import com.google.gson.annotations.SerializedName


data class RaitingModel (
  @SerializedName("raitings" ) var raitings : Raitings? = Raitings()
)