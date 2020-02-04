package com.example.daggerexample.di.main

import com.example.daggerexample.ui.main.posts.PostsFragment
import com.example.daggerexample.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Daniil Pavlenko on 02.02.20.
 */
@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributePostsFragment(): PostsFragment
}