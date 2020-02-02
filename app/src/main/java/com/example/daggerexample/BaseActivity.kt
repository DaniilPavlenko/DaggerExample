package com.example.daggerexample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.daggerexample.ui.auth.AuthActivity
import com.example.daggerexample.util.AuthResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by Daniil Pavlenko on 02.02.20.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    companion object {
        private const val TAG = "BaseActivity"
    }

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        sessionManager.getAuthUser().observe(this, Observer {
            when (it) {
                is AuthResource.Loading -> {
                    Log.d(TAG, "subscribeObservers: loading...")
                }
                is AuthResource.Success -> {
                    Log.d(TAG, "subscribeObservers: success ${it.data!!.website}")
                }
                is AuthResource.Error -> {
                    Log.d(TAG, "subscribeObservers: error")
                }
                is AuthResource.LogOut -> {
                    Log.d(TAG, "subscribeObservers: logOut")
                    navToLoginScreen()
                }
            }
        })
    }

    private fun navToLoginScreen() {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finish()
    }
}