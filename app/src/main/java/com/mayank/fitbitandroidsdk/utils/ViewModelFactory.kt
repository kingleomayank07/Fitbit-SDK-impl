package com.mayank.fitbitandroidsdk.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayank.fitbitandroidsdk.data.api.ApiService
import com.mayank.fitbitandroidsdk.data.repository.MainRepository
import com.mayank.fitbitandroidsdk.ui.viewmodel.MainViewModel

class ViewModelFactory(
    private val apiHelper: ApiService
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(MainRepository(apiHelper)) as T
            }
            else -> {
                throw IllegalArgumentException("Unknown class name")
            }
        }
    }
}
