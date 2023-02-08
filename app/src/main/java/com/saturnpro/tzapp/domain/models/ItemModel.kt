package com.saturnpro.tzapp

import com.google.gson.annotations.SerializedName


data class ItemModel (
  @SerializedName("image" ) var image : String? = null,
  @SerializedName("title" ) var title : String? = null
)