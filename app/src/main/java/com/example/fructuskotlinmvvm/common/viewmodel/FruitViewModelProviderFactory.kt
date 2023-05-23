package com.example.fructuskotlinmvvm.common.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import FruitRepository

class FruitViewModelProviderFactory(
    val app:Application,
    private val fruitRepository: FruitRepository)
    :ViewModelProvider.Factory{

        fun <T : ViewModel?> Create(modelClass: Class<T>): T{
            return FruitViewModel(app , fruitRepository) as T
        }
}