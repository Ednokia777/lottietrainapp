package com.saturnpro.tzapp.data.api

import com.saturnpro.tzapp.RaitingModel
import retrofit2.Call
import retrofit2.http.GET

interface DownloadApi {
    @GET("/testAndroidData")
    fun getAllRaitings(): Call<List<RaitingModel>?>
}