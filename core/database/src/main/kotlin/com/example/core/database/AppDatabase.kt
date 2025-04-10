package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.database.dao.MovieDao
import com.example.core.database.model.DeletedMovieEntity

@Database(entities = [DeletedMovieEntity::class], version = AppDatabase.Companion.DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        const val DB_NAME = "base_project_database"
        const val DB_VERSION = 1
    }
}