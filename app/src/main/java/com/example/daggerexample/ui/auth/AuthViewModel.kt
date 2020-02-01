package com.example.daggerexample.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerexample.model.User
import com.example.daggerexample.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */

class AuthViewModel @Inject constructor(
    private val authApi: AuthApi
) : ViewModel() {

    companion object {
        private const val TAG = "AuthViewModel"
    }

    private val authUser = MediatorLiveData<User>()

    fun authenticateWithId(userId: Long) {
        val source = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId)
                .subscribeOn(Schedulers.io())
        )
        authUser.addSource(source) {
            authUser.value = it
            authUser.removeSource(source)
        }
    }

    fun observeUser(): LiveData<User> {
        return authUser
    }
}