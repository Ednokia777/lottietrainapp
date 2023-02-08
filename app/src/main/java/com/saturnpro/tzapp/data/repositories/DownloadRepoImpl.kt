package com.saturnpro.tzapp.data.repositories

import com.saturnpro.tzapp.data.api.DownloadApi
import com.saturnpro.tzapp.domain.repositories.DownloadRepository
import com.saturnpro.tzapp.ItemModel
import com.saturnpro.tzapp.Raitings
import retrofit2.Retrofit
import retrofit2.awaitResponse
import kotlin.reflect.full.memberProperties

class DownloadRepoImpl(
    private val retrofit: Retrofit
) : DownloadRepository {
    private val downloadRaitingsApi by lazy { retrofit.create(DownloadApi::class.java) }


    override suspend fun downloadRaitingList(): List<ItemModel> {
        val list = ArrayList<ItemModel>()
        val response = downloadRaitingsApi.getAllRaitings()
        val prop = response!!::class.memberProperties.forEach {
            val raitings = it.getter.call(response) as Raitings
//            Log.w("wtf","raitings = ${raitings}")
            raitings::class.memberProperties.forEach {
                val value = it.call(raitings) as ItemModel
                list.add(value)
//                Log.w("wtf","list size = ${list.size}")
            }
        }
        return list

//        return try {
//
//        } catch (e: Exception) {
//            emptyList()
//        }
    }
}