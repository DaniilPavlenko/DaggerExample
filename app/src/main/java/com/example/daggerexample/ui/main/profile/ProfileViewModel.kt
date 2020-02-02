package com.example.daggerexample.ui.main.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.daggerexample.SessionManager
import com.example.daggerexample.model.User
import com.example.daggerexample.util.AuthResource
import javax.inject.Inject

/**
 * Created by Daniil Pavlenko on 02.02.20.
 */
class ProfileViewModel @Inject constructor(
    private val sessionManager: SessionManager
) : ViewModel() {

    companion object {
        private const val TAG = "ProfileViewModel"
    }

    init {
        Log.d(TAG, "initialized")
    }

    fun getAuthenticatedUser(): LiveData<AuthResource<User>> {
        return sessionManager.getAuthUser()
    }
}