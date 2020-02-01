package com.example.daggerexample.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
private const val TAG = "AuthViewModel"

class AuthViewModel @Inject constructor() : ViewModel() {

    init {
        Log.d(TAG, "AuthViewModel: is working...")
    }
}