package com.yaseminuctas.mvvm.data.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yaseminuctas.mvvm.ui.MainViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}