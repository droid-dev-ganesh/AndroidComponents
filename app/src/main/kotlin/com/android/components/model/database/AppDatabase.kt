package com.android.components.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.android.components.model.Post
import com.android.components.model.PostDao

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}