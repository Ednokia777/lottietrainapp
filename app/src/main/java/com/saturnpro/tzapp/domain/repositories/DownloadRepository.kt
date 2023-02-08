package com.saturnpro.tzapp.domain.repositories

import com.saturnpro.tzapp.ItemModel
import com.saturnpro.tzapp.Raitings

interface DownloadRepository {
    suspend fun downloadRaitingList(): List<ItemModel>
}