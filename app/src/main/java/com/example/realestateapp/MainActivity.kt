package com.example.realestateapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realestateapp.fragments.ResultsFragment
import com.example.realestateapp.fragments.SearchFragment
import com.example.realestateapp.fragments.WishlistFragment
import com.example.realestateapp.models.Listing
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.ParseUser

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var fragmentManager: FragmentManager
    lateinit var fragmentToShow: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        fragmentManager = supportFragmentManager

        setupNavOnClick()

        bottomNavigationView.selectedItemId = R.id.action_search
    }

    private fun setupNavOnClick() {
        bottomNavigationView.setOnItemSelectedListener {
            item ->

            when (item.itemId) {
                R.id.action_search -> {
                    fragmentToShow = SearchFragment()
                }
                R.id.action_results -> {
                    fragmentToShow = ResultsFragment()
                }
                R.id.action_wishlist -> {
                    fragmentToShow = WishlistFragment()
                }
                R.id.action_signout -> {
                    logoutUser()
                }
            }
            fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            true
        }
    }

    private fun logoutUser() {
        ParseUser.logOut()
        goToLoginActivity()
    }

    private fun goToLoginActivity() {
        ParseUser.logOut()
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }


}
