package com.aditya.fakerapidagger.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aditya.fakerapidagger.models.Products

@Database(entities = [Products::class], version = 1)
abstract class FakerDB : RoomDatabase() {
    abstract fun getFakerDAO(): FakerDAO
}