package com.example.daggerexample.di.main

import androidx.lifecycle.ViewModel
import com.example.daggerexample.di.ViewModelKey
import com.example.daggerexample.ui.main.posts.PostsViewModel
import com.example.daggerexample.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Daniil Pavlenko on 02.02.20.
 */
@Module
abstract class MainViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel
}