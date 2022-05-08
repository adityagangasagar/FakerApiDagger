package com.aditya.fakerapidagger.retrofit

import com.aditya.fakerapidagger.models.Products
import com.aditya.fakerapidagger.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {
    @GET(Constants.products)
    suspend fun getProducts(): Response<List<Products>>
}