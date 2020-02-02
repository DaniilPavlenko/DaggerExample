package com.example.daggerexample.ui.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggerexample.R
import com.example.daggerexample.ui.main.MainActivity
import com.example.daggerexample.util.AuthResource
import com.example.daggerexample.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    companion object {
        private const val TAG = "AuthActivity"
    }

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    @Inject
    lateinit var requestManager: RequestManager

    private lateinit var viewModel: AuthViewModel
    private lateinit var edUserId: EditText
    private lateinit var btnLogin: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var ivUserPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        edUserId = findViewById(R.id.ed_auth_login)
        btnLogin = findViewById(R.id.btn_auth_login)
        progressBar = findViewById(R.id.pb_auth)
        ivUserPhoto = findViewById(R.id.iv_auth_user_logo)
        btnLogin.setOnClickListener { attemptLogin() }
        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.observeAuthState().observe(this, Observer { result ->
            when (result) {
                is AuthResource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    Log.d(TAG, "subscribeObservers: loading...")
                }
                is AuthResource.Success -> {
                    progressBar.visibility = View.GONE
                    onLoginSuccess()
                    Log.d(TAG, "subscribeObservers: success ${result.data!!.webSite}")
                }
                is AuthResource.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                    Log.d(TAG, "subscribeObservers: error")
                }
                is AuthResource.LogOut -> {
                    progressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun onLoginSuccess() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun attemptLogin() {
        if (edUserId.text.toString().isBlank()) {
            return
        }
        viewModel.authenticateWithId(edUserId.text.toString().toLong())
    }
}