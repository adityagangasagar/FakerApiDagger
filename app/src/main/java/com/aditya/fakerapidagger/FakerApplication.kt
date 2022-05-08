package com.aditya.fakerapidagger

import android.app.Application
import com.aditya.fakerapidagger.di.ApplicationComponent
import com.aditya.fakerapidagger.di.DaggerApplicationComponent

class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}