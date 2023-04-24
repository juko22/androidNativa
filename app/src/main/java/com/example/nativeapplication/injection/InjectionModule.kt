package com.example.nativeapplication.injection

import android.content.Context
import androidx.room.Room
import com.example.nativeapplication.App
import com.example.nativeapplication.common.DATABASE_NAME
import com.example.nativeapplication.repository.AppRepository
import com.example.nativeapplication.repository.cache.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InjectionModule{

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) = Room
        .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideAppRepository(database: AppDatabase): AppRepository = AppRepository(database.appDao())
}