package com.example.daggerexample.di.auth

import androidx.lifecycle.ViewModel
import com.example.daggerexample.di.ViewModelKey
import com.example.daggerexample.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
@Module
abstract class AuthViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}