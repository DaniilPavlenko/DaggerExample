package com.example.daggerexample

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

private const val TAG = "AuthActivity"

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        setupLogo()
    }

    private fun setupLogo() {
        requestManager
            .load(ContextCompat.getDrawable(this, R.drawable.ic_user_logo))
            .into(findViewById(R.id.iv_auth_user_logo))
    }
}
