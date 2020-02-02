package com.example.daggerexample.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.daggerexample.R

class ProfileFragment : Fragment() {

    companion object {
        private const val TAG = "ProfileFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(context, TAG, Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}