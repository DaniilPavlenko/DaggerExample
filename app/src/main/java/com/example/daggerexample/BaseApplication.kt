package com.example.daggerexample

import com.example.daggerexample.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by Daniil Pavlenko on 29.01.20.
 */
class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}