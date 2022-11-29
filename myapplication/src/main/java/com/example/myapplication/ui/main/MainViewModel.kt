package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModel
import com.example.myapplication.businesslayer.CatProvider
import com.example.myapplication.datalayer.IAccessor

class MainViewModel : ViewModel() {





    private val accessor = IAccessor.create()
    private val provider = CatProvider(accessor)
    suspend fun getCats() = provider.getCats(0, 100)
}