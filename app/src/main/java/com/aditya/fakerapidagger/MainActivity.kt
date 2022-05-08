package com.aditya.fakerapidagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aditya.fakerapidagger.viewmodels.MainViewModels
import com.aditya.fakerapidagger.viewmodels.MainViewModelsFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModels: MainViewModels

    @Inject
    lateinit var mainViewModelsFactory: MainViewModelsFactory

    private val products: TextView
    get() = findViewById(R.id.tvProducts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FakerApplication).applicationComponent.inject(this)

        // get Model Object
        val map = (application as FakerApplication)
            .applicationComponent.getMap()

        mainViewModels = ViewModelProvider(this,mainViewModelsFactory)[MainViewModels::class.java]

        mainViewModels.productsLiveData.observe(this, Observer {
            products.text = it.joinToString { x-> x.title + "\n\n" }
        })

    }
}