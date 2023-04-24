package com.example.nativeapplication.injection

import androidx.annotation.RestrictTo
import com.example.nativeapplication.repository.AppRepository
import com.example.nativeapplication.ui.MainViewModel

var viewModelProvider = ViewModelProvider()
    private set

@RestrictTo(RestrictTo.Scope.TESTS)
fun setupViewModelProvider(testInjector: ViewModelProvider) {
    viewModelProvider = testInjector
}

open class ViewModelProvider {

    open fun provideGameViewModel(repository: AppRepository) = MainViewModel(repository)
}