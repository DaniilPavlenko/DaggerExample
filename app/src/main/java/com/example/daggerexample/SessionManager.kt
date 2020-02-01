package com.example.daggerexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.daggerexample.model.User
import com.example.daggerexample.util.AuthResource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
@Singleton
class SessionManager @Inject constructor() {
    companion object {
        private const val TAG = "SessionManager"
    }

    private val cachedUser = MediatorLiveData<AuthResource<User>>()

    fun authenticateWithId(source: LiveData<AuthResource<User>>) {
        cachedUser.value = AuthResource.Loading()
        cachedUser.addSource(source) {
            cachedUser.value = it
            cachedUser.removeSource(source)
        }
    }

    fun logOut() {
        Log.d(TAG, "logOut: logging out...")
        cachedUser.value = AuthResource.LogOut()
    }

    fun getAuthUser(): LiveData<AuthResource<User>> {
        return cachedUser
    }
}