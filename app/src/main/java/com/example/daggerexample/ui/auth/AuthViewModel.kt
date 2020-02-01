package com.example.daggerexample.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.daggerexample.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */

class AuthViewModel @Inject constructor(
    authApi: AuthApi
) : ViewModel() {

    companion object {
        private const val TAG = "AuthViewModel"
    }

    init {
        authApi.getUser(1).toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d(TAG, "user: ${it.userName}")
            }, {
                Log.e(TAG, "error: ", it)
            })
    }
}