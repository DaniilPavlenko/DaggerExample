package com.example.daggerexample.di.main

import com.example.daggerexample.network.main.MainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author Daniil Pavlenko on 04.02.20.
 */
@Module
abstract class MainModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideMainApi(retrofit: Retrofit): MainApi {
            return retrofit.create(MainApi::class.java)
        }
    }
}