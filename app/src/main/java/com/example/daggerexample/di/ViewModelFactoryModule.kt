package com.example.daggerexample.di

import androidx.lifecycle.ViewModelProvider
import com.example.daggerexample.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModule(
        providerFactory: ViewModelProviderFactory
    ): ViewModelProvider.Factory
}