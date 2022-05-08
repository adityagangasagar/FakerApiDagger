package com.aditya.fakerapidagger.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.fakerapidagger.models.Products
import com.aditya.fakerapidagger.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModels @Inject constructor(
    private val repository: ProductRepository,
    private val randomize: Randomize
) : ViewModel() {

    val productsLiveData: LiveData<List<Products>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }
}

class Randomize @Inject constructor() {
    fun doAction() {
        Log.d("TEST", "doAction: ")
    }
}