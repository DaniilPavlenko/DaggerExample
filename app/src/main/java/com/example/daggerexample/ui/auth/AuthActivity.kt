package com.example.daggerexample.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggerexample.R
import com.example.daggerexample.util.Resource
import com.example.daggerexample.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

private const val TAG = "AuthActivity"

class AuthActivity : DaggerAppCompatActivity() {

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
        viewModel.observeUser().observe(this, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    Log.d(TAG, "subscribeObservers: loading...")
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    setupLogo()
                    Log.d(TAG, "subscribeObservers: success ${result.data!!.webSite}")
                }
                is Resource.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                    Log.d(TAG, "subscribeObservers: error")
                }
            }
        })
    }

    private fun attemptLogin() {
        if (edUserId.text.toString().isBlank()) {
            return
        }
        viewModel.authenticateWithId(edUserId.text.toString().toLong())
    }

    private fun setupLogo() {
        requestManager
            .load(ContextCompat.getDrawable(this, R.drawable.ic_user_logo))
            .into(ivUserPhoto)
    }
}
