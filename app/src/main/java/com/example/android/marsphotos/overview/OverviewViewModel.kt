

package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.CountryApi
import com.example.android.marsphotos.network.CountryPhoto
import com.example.android.marsphotos.network.Photo
import kotlinx.coroutines.launch


class OverviewViewModel : ViewModel() {


    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status


    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos



    init {
        getCountryPhotos()
    }


    private fun getCountryPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = CountryApi.retrofitService.getPhotos().data
                _status.value = "Success: Mars properties retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
