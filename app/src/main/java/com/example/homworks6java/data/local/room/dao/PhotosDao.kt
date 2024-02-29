package com.example.homworks6java.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homworks6java.data.local.room.entitiy.PhotoEntity

@Dao
interface PhotosDao {

    @Query("SELECT * FROM photo_entiti")
    fun getPhotos(): LiveData<List<PhotoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: PhotoEntity)
}