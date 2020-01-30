package com.example.daggerexample.di

import com.example.daggerexample.AuthActivity
import com.example.daggerexample.Car
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by Daniil Pavlenko on 29.01.20.
 */
@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity

    @Module
    companion object {

    }
}