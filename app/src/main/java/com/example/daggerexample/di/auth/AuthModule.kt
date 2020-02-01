package com.example.daggerexample.di.auth

import com.example.daggerexample.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
@Module
abstract class AuthModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideAuthApi(retrofit: Retrofit): AuthApi {
            return retrofit.create(AuthApi::class.java)
        }
    }

}