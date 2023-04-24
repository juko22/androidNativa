package com.example.nativeapplication.repository.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nativeapplication.repository.dao.AppDao
import com.example.nativeapplication.repository.model.NoteDBModel

@Database(entities = [NoteDBModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}