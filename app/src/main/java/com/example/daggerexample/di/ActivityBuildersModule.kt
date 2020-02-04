package com.example.daggerexample.di

import com.example.daggerexample.di.auth.AuthModule
import com.example.daggerexample.di.auth.AuthViewModelsModule
import com.example.daggerexample.di.main.MainFragmentBuildersModule
import com.example.daggerexample.di.main.MainModule
import com.example.daggerexample.di.main.MainViewModelsModule
import com.example.daggerexample.ui.auth.AuthActivity
import com.example.daggerexample.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Daniil Pavlenko on 29.01.20.
 */
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class, AuthModule::class])
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector(
        modules = [
            MainFragmentBuildersModule::class,
            MainViewModelsModule::class,
            MainModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

    @Module
    companion object {

    }
}