package com.aditya.fakerapidagger.di

import androidx.lifecycle.ViewModel
import com.aditya.fakerapidagger.viewmodels.MainViewModels
import com.aditya.fakerapidagger.viewmodels.MainViewModels2
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(MainViewModels::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModels: MainViewModels): ViewModel

    @Binds
    @ClassKey(MainViewModels2::class)
    @IntoMap
    abstract fun mainViewModel2(mainViewModels2: MainViewModels2): ViewModel
}