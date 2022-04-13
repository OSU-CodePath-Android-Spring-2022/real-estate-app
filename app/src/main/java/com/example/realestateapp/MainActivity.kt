package com.example.realestateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.realestateapp.fragments.LoginFragment
import com.example.realestateapp.fragments.ResultsFragment
import com.example.realestateapp.fragments.SearchFragment
import com.example.realestateapp.fragments.WishlistFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val fragmentManager: FragmentManager = supportFragmentManager
        lateinit var fragmentToShow: Fragment

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            item ->

            when (item.itemId) {
                R.id.action_search -> {
                    // todo: navigate to the search screen
                    fragmentToShow = SearchFragment()
                }
                R.id.action_results -> {
                    // todo: navigate to the results screen
                    fragmentToShow = ResultsFragment()
                }
                R.id.action_wishlist -> {
                    // todo: navigate to the wishlist screen
                    fragmentToShow = WishlistFragment()
                }
                R.id.action_signout -> {
                    // todo: navigate to the login screen
                    fragmentToShow = LoginFragment()
                }
            }
            fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            true
        }
        // Set default fragment to show
        bottomNavigationView.selectedItemId = R.id.action_search
    }
}
