package com.example.daggerexample.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.daggerexample.BaseActivity
import com.example.daggerexample.R
import com.example.daggerexample.ui.main.profile.ProfileFragment

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
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ProfileFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                sessionManager.logOut()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}