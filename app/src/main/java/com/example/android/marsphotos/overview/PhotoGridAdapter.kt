package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.CountryPhoto

class PhotoGridAdapter : ListAdapter<CountryPhoto, PhotoGridAdapter.CountryPhotoViewHolder>(DiffCallback) {

    class CountryPhotoViewHolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(countryPhoto: CountryPhoto) {
            binding.photo = countryPhoto
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.CountryPhotoViewHolder {
        return CountryPhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.CountryPhotoViewHolder, position: Int) {
        val countryPhoto = getItem(position)
        holder.bind(countryPhoto)
    }


    companion object DiffCallback : DiffUtil.ItemCallback<CountryPhoto>() {
        override fun areItemsTheSame(oldItem: CountryPhoto, newItem: CountryPhoto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CountryPhoto, newItem: CountryPhoto): Boolean {
            return oldItem == newItem
        }
    }
}