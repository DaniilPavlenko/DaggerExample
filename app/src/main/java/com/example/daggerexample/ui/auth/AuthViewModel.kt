package com.example.daggerexample.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerexample.model.User
import com.example.daggerexample.network.auth.AuthApi
import com.example.daggerexample.util.Resource
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

    private val authUser = MediatorLiveData<Resource<User>>()

    fun authenticateWithId(userId: Long) {
        authUser.value = Resource.Loading(null)
        val source = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId)
                .onErrorReturn { User().apply { id = -1 } }
                .map {
                    if (it.id < 1) {
                        Resource.Error("Error on get user", null)
                    } else {
                        Resource.Success(it)
                    }
                }
                .subscribeOn(Schedulers.io())
        )
        authUser.addSource(source) {
            authUser.value = it
            authUser.removeSource(source)
        }
    }

    fun observeUser(): LiveData<Resource<User>> {
        return authUser
    }
}