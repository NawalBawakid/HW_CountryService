package com.example.android.marsphotos

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.example.android.marsphotos.network.Photo
import com.example.android.marsphotos.overview.CountryApiStatus
import com.example.android.marsphotos.overview.PhotoGridAdapter


@BindingAdapter("imageUrl")
fun ImageView.bindImage(imageUri: String?) {
    imageUri?.let{
        val imageLoader = ImageLoader.Builder(context)
            .componentRegistry { add(SvgDecoder(context)) }
            .build()

        this.load(uri = imageUri, imageLoader = imageLoader) {
            crossfade(true)
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image) }
    }
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Photo>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}


@BindingAdapter("cityApiStatus")
fun bindStatus(statusImageView: ImageView, status: CountryApiStatus?) {
    when (status) {
        CountryApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CountryApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        CountryApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}