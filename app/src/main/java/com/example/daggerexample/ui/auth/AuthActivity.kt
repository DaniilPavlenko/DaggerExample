package com.example.daggerexample.ui.auth

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.daggerexample.R
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)
        setupLogo()
    }

    private fun setupLogo() {
        requestManager
            .load(ContextCompat.getDrawable(this, R.drawable.ic_user_logo))
            .into(findViewById(R.id.iv_auth_user_logo))
    }
}
