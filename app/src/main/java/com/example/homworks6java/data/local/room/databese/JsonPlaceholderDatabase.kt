package com.example.homworks6java.data.local.room.databese

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homworks6java.data.local.room.dao.PhotosDao
import com.example.homworks6java.data.local.room.entitiy.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
abstract class JsonPlaceholderDatabase : RoomDatabase() {

    abstract fun photosDao(): PhotosDao
}