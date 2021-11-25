

package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.CountryApi
import com.example.android.marsphotos.network.Photo
import kotlinx.coroutines.launch

enum class CountryApiStatus { LOADING, ERROR, DONE }


class OverviewViewModel : ViewModel() {


    private val _status = MutableLiveData<CountryApiStatus>()
    val status: LiveData<CountryApiStatus> = _status


    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos



    init {
        getCountryPhotos()
    }


    private fun getCountryPhotos() {
        viewModelScope.launch {
            _status.value = CountryApiStatus.LOADING
            try {
                _photos.value = CountryApi.retrofitService.getPhotos().data
                _status.value = CountryApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CountryApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}
