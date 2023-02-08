package com.saturnpro.tzapp.domain.usecases

import com.saturnpro.tzapp.domain.repositories.DownloadRepository
import com.saturnpro.tzapp.ItemModel

class DownloadRaitingsUseCases (private val downloadRepository: DownloadRepository) {
    suspend fun execute(): List<ItemModel> {
        return downloadRepository.downloadRaitingList()
    }
}