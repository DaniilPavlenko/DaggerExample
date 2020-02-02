package com.example.daggerexample.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.daggerexample.R
import com.example.daggerexample.model.User
import com.example.daggerexample.util.AuthResource
import com.example.daggerexample.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {

    companion object {
        private const val TAG = "ProfileFragment"
    }

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var viewModel: ProfileViewModel

    private lateinit var ivUserPhoto: ImageView
    private lateinit var tvUserName: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var tvUserWebsite: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            ivUserPhoto = findViewById(R.id.ivProfileUserImage)
            tvUserName = findViewById(R.id.tvProfileUserName)
            tvUserEmail = findViewById(R.id.tvProfileUserEmail)
            tvUserWebsite = findViewById(R.id.tvProfileUserWebsite)
        }
        viewModel = ViewModelProvider(this, providerFactory)
            .get(ProfileViewModel::class.java)
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.getAuthenticatedUser().run {
            removeObservers(viewLifecycleOwner)
            observe(viewLifecycleOwner, Observer { authUser ->
                when (authUser) {
                    is AuthResource.Success -> {
                        setUserDetails(authUser.data!!)
                    }
                    is AuthResource.Error -> {
                        setErrorDetails(authUser.message!!)
                    }
                }
            })
        }
    }

    private fun setErrorDetails(message: String) {
        tvUserName.text = message
        tvUserEmail.text = "error"
        tvUserWebsite.text = "error"
    }

    private fun setUserDetails(user: User) {
        with(user) {
            tvUserName.text = userName
            tvUserEmail.text = email
            tvUserWebsite.text = website
        }
    }
}