package com.example.homworks6java.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homworks6java.data.local.room.entitiy.PhotoEntity
import com.example.homworks6java2.databinding.ItemPhotoBinding

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private var photos = mutableListOf<PhotoEntity>()

    fun setPhotos(photos: List<PhotoEntity>) {
        this.photos.addAll(photos)
        this.photos.distinctBy {
            it.id
        }
        notifyDataSetChanged()
    }

    inner class PhotoViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(photo: PhotoEntity) = with(binding){
            Glide.with(ivPhoto.context)
                .load(photo.url)
                .into(ivPhoto)
            tvTitle.text = photo.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.onBind(photos[position])
    }
}