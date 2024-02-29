package com.example.homworks6java.ui.fragments.home

import androidx.lifecycle.ViewModel
import com.example.homworks6java.data.PhotosRepository

class HomeViewModel : ViewModel() {

    private val photosRepository = PhotosRepository()

    fun getPhotos() = photosRepository.getPhotos()
}