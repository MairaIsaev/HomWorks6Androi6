package com.example.homworks6java.data.remote.apiservise

import com.example.homworks6java.data.remote.model.Photo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

private const val END_POINT = "photos"

interface PhotosApiService {

    @POST(END_POINT)
    fun addPhoto(
        @Body photo: Photo
    ) : Call<Photo>
}