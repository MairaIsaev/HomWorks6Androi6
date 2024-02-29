package com.example.homworks6java.data

import com.example.homworks6java.data.local.room.RoomClient
import com.example.homworks6java.data.remote.RetrofitClient
import com.example.homworks6java.data.remote.model.Photo
import com.example.homworks6java.data.remote.model.toEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosRepository {

    private val photosApiService = RetrofitClient.photosApiService
    private val photosDao = RoomClient.database.photosDao()

    fun addPhoto(
        photo: Photo,
        onResponse: (photo: Photo) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        photosApiService.addPhoto(photo).enqueue(object : Callback<Photo> {
            override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Photo>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }

    fun getPhotos() = photosDao.getPhotos()

    fun insertPhoto(photo: Photo) {
        photosDao.insertPhoto(photo.toEntity())
    }
}