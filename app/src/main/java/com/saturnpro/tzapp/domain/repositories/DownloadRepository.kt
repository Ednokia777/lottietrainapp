package com.saturnpro.tzapp.domain.repositories

import com.saturnpro.tzapp.RaitingModel

interface DownloadRepository {
    suspend fun downloadRaitingList(): List<RaitingModel>?
}