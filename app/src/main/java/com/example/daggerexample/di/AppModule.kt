package com.example.daggerexample.di

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.daggerexample.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Daniil Pavlenko on 30.01.20.
 */
@Module
class AppModule {
    @Module
    companion object {

        @JvmStatic
        @Singleton
        @Provides
        fun provideRequestOptions(): RequestOptions {
            return RequestOptions()
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
        }

        @JvmStatic
        @Singleton
        @Provides
        fun provideGlideInstance(
            application: Application,
            requestOptions: RequestOptions
        ): RequestManager {
            return Glide.with(application)
                .setDefaultRequestOptions(requestOptions)
        }
    }
}