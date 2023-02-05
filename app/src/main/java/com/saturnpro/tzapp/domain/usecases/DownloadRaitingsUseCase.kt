package com.saturnpro.tzapp.domain.usecases

import com.saturnpro.tzapp.RaitingModel
import com.saturnpro.tzapp.domain.repositories.DownloadRepository

class DownloadRaitingsUseCases (private val downloadRepository: DownloadRepository) {
    suspend fun execute(): List<RaitingModel>? {
        return downloadRepository.downloadRaitingList()
    }
}