package com.saturnpro.tzapp.domain.models.classes

import com.google.gson.annotations.SerializedName

data class SixClass (
    @SerializedName("image" ) var image : String? = null,
    @SerializedName("title" ) var title : String? = null
)