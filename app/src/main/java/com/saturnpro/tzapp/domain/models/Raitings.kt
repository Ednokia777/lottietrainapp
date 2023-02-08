package com.saturnpro.tzapp

import com.google.gson.annotations.SerializedName


data class Raitings (
  @SerializedName("0" ) var x0 : ItemModel,
  @SerializedName("1" ) var x1 : ItemModel,
  @SerializedName("2" ) var x2 : ItemModel,
  @SerializedName("3" ) var x3 : ItemModel,
  @SerializedName("4" ) var x4 : ItemModel,
  @SerializedName("5" ) var x5 : ItemModel,
  @SerializedName("6" ) var x6 : ItemModel,
  @SerializedName("7" ) var x7 : ItemModel,
  @SerializedName("8" ) var x8 : ItemModel,
)