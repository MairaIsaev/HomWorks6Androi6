package com.example.homworks6java.data.local.room

import android.content.Context
import androidx.room.Room
import com.example.homworks6java.data.local.room.databese.JsonPlaceholderDatabase

object RoomClient {

    private const val DATABASE_NAME = "json-placeholder_database"
    lateinit var database: JsonPlaceholderDatabase
        private set

    fun init(context: Context) {
        database = Room.databaseBuilder(
            context, JsonPlaceholderDatabase::class.java, DATABASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}