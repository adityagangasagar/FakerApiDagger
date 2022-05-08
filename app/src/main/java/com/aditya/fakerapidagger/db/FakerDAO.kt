package com.aditya.fakerapidagger.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aditya.fakerapidagger.models.Products
import retrofit2.http.GET

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Products>)

    @Query("Select * from Products")
    suspend fun getProducts(): List<Products>
}