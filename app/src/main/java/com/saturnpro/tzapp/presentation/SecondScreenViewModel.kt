package com.saturnpro.tzapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saturnpro.tzapp.domain.usecases.DownloadRaitingsUseCases
import com.saturnpro.tzapp.ItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor(
    private val downloadRaitingsUseCases: DownloadRaitingsUseCases,
) : ViewModel() {
    private val _raitingsLiveData = MutableLiveData<List<ItemModel>>()
    val raitingsLiveData = _raitingsLiveData
    var animatiponP = MutableLiveData<Float>()
    var progressBar = MutableLiveData<Int>()

    suspend fun getRaitingsList() {
        val raitingsBody = downloadRaitingsUseCases.execute()
        _raitingsLiveData.value = raitingsBody
    }

    fun getLottiProgress(): Float? = animatiponP.value
    fun setLottiProgress(progress: Float) {
        animatiponP.value = progress
    }

    fun getPbProgress(): Int? = progressBar.value
    fun setPbProgress(progress: Int) {
        progressBar.value = progress
    }


}