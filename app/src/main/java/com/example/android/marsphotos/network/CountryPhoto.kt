package com.example.android.marsphotos.network

data class CountryPhoto(val error: Boolean, val msg: String, val data: List<Photo>) : List<Photo>

data class Photo(val name: String, val flag: String)