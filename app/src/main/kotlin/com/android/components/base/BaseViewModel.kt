package com.android.components.base

import android.arch.lifecycle.ViewModel
import com.android.components.injection.component.DaggerViewModelInjector
import com.android.components.injection.component.ViewModelInjector
import com.android.components.injection.module.NetworkModule
import com.android.components.ui.post.PostListViewModel
import com.android.components.ui.post.PostViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }
}