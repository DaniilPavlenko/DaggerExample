package com.example.daggerexample.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerexample.network.auth.AuthApi
import javax.inject.Inject

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {
    companion object {
        private const val TAG = "AuthViewModel"
    }

    init {
        Log.d(TAG, "AuthViewModel: is working...")
    }
}