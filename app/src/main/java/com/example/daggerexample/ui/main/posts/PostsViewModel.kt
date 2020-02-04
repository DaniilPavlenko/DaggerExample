package com.example.daggerexample.ui.main.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerexample.SessionManager
import com.example.daggerexample.network.main.MainApi
import javax.inject.Inject

/**
 * @author Daniil Pavlenko on 04.02.20.
 */
class PostsViewModel @Inject constructor(
    val sessionManager: SessionManager,
    val mainApi: MainApi
) : ViewModel() {

    init {
        Log.d(TAG, "success init")
    }

    companion object {
        private const val TAG = "PostsViewModel"
    }
}