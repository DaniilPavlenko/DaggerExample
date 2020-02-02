package com.example.daggerexample.ui.main

import android.os.Bundle
import android.widget.Toast
import com.example.daggerexample.BaseActivity
import com.example.daggerexample.R

/**
 * Created by Daniil Pavlenko on 02.02.20.
 */
class MainActivity : BaseActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, TAG, Toast.LENGTH_SHORT).show()
    }
}