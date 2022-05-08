package com.aditya.fakerapidagger.viewmodels

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModels2 @Inject constructor(private val randomize: Randomize) : ViewModel() {
    init {
        randomize.doAction()
    }
}