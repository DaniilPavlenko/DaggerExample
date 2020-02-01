package com.example.daggerexample.di

import com.example.daggerexample.di.auth.AuthViewModelsModule
import com.example.daggerexample.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Daniil Pavlenko on 29.01.20.
 */
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class])
    abstract fun contributeAuthActivity(): AuthActivity

    @Module
    companion object {

    }
}