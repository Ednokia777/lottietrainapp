package com.saturnpro.tzapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saturnpro.tzapp.RaitingModel
import com.saturnpro.tzapp.domain.usecases.DownloadRaitingsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor(
    private val downloadRaitingsUseCases: DownloadRaitingsUseCases,
) : ViewModel() {
    private var _raitingsLiveData = MutableLiveData<List<RaitingModel>?>()
    private var raitingsLiveData = _raitingsLiveData

    suspend fun getRaitingsList() {
        val raitingsBody = downloadRaitingsUseCases.execute()
        if (raitingsBody?.isEmpty() == true) _raitingsLiveData.value =
            emptyList() else _raitingsLiveData.value = raitingsBody
    }

}