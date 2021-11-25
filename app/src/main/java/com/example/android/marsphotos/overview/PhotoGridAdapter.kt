package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.Photo

class PhotoGridAdapter : ListAdapter<Photo, PhotoGridAdapter.CountryPhotoViewHolder>(DiffCallback) {

    class CountryPhotoViewHolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            binding.photo = photo
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.CountryPhotoViewHolder {
        return CountryPhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.CountryPhotoViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
    }


    companion object DiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.flag == newItem.flag
        }
    }
}