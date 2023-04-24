package com.example.nativeapplication

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.example.nativeapplication.common.LineNumberDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
open class App() : Application(), ViewModelStoreOwner {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(LineNumberDebugTree())
        }
    }

    override val viewModelStore: ViewModelStore
        get() = appViewModelStore

    companion object {

        private val appViewModelStore: ViewModelStore by lazy { ViewModelStore() }

    }
}