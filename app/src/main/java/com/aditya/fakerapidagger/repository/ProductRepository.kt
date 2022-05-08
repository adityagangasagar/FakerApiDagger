package com.aditya.fakerapidagger.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aditya.fakerapidagger.db.FakerDB
import com.aditya.fakerapidagger.models.Products
import com.aditya.fakerapidagger.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI,private val fakerDB: FakerDB) {

    private val _products = MutableLiveData<List<Products>>()
    val products:LiveData<List<Products>>
    get() = _products

    suspend fun getProduct(){
        val result = fakerAPI.getProducts()
        if (result.isSuccessful && result.body() != null){
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}