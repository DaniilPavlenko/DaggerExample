package com.example.daggerexample.ui.main.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Daniil Pavlenko on 02.02.20.
 */
class ProfileViewModel @Inject constructor() : ViewModel() {

    companion object {
        private const val TAG = "ProfileViewModel"
    }

    init {
        Log.d(TAG, "initialized")
    }
}