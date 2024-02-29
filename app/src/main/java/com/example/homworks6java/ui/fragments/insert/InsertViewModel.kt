package com.example.homworks6java.ui.fragments.insert

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homworks6java.data.PhotosRepository
import com.example.homworks6java.data.remote.model.Photo
import com.example.homworks6java.utils.UiState

class InsertViewModel : ViewModel() {

    private val photosRepository = PhotosRepository()

    private val _photoLiveData = MutableLiveData<UiState<Photo>>(UiState.Loading())
    val photoLiveData: LiveData<UiState<Photo>> = _photoLiveData

    fun addPhoto(photo: Photo) {
        photosRepository.addPhoto(
            photo = photo,
            onResponse = {
                photosRepository.insertPhoto(photo)
                _photoLiveData.value = UiState.Success(photo)
            },
            onFailure = { message, t ->
                Log.e("addPhoto", message, t)
                _photoLiveData.value = UiState.Error(message, t)
            }
        )
    }
}