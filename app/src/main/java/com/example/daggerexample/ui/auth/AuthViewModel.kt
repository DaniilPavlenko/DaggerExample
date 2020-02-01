package com.example.daggerexample.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerexample.SessionManager
import com.example.daggerexample.model.User
import com.example.daggerexample.network.auth.AuthApi
import com.example.daggerexample.util.AuthResource
import com.example.daggerexample.util.Resource
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */

class AuthViewModel @Inject constructor(
    private val authApi: AuthApi,
    private val sessionManager: SessionManager
) : ViewModel() {

    companion object {
        private const val TAG = "AuthViewModel"
    }

    private val authUser = MediatorLiveData<Resource<User>>()

    fun authenticateWithId(userId: Long) {
        Log.d(TAG, "authenticateWithId: attempting to login")
        sessionManager.authenticateWithId(queryUserId(userId))
    }

    private fun queryUserId(userId: Long): LiveData<AuthResource<User>> {
        return LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId)
                .onErrorReturn { User().apply { id = -1 } }
                .map {
                    if (it.id < 1) {
                        AuthResource.Error("Error on get user", null)
                    } else {
                        AuthResource.Success(it)
                    }
                }
                .subscribeOn(Schedulers.io())
        )
    }

    fun observeAuthState(): LiveData<AuthResource<User>> {
        return sessionManager.getAuthUser()
    }
}