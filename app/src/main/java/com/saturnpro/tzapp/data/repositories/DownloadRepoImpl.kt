package com.saturnpro.tzapp.data.repositories

import com.saturnpro.tzapp.RaitingModel
import com.saturnpro.tzapp.data.api.DownloadApi
import com.saturnpro.tzapp.domain.repositories.DownloadRepository
import retrofit2.Retrofit
import retrofit2.awaitResponse

class DownloadRepoImpl(
    private val retrofit: Retrofit
) : DownloadRepository {
    private val downloadRaitingsApi by lazy { retrofit.create(DownloadApi::class.java) }


    override suspend fun downloadRaitingList(): List<RaitingModel>? {
        return try {
            downloadRaitingsApi.getAllRaitings().awaitResponse().body()
        } catch (e: Exception) {
            emptyList()
        }
    }

}