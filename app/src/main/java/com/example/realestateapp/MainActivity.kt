package com.example.realestateapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
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
                    fragmentToShow = SearchFragment()
                }
                R.id.action_results -> {
                    fragmentToShow = ResultsFragment()
                }
                R.id.action_wishlist -> {
                    fragmentToShow = WishlistFragment()
                }
                R.id.action_signout -> {
                    goToLoginScreen()
                }
            }
            fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            true
        }
        bottomNavigationView.selectedItemId = R.id.action_search
    }

    private fun goToLoginScreen() {
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        intent.putExtra("didUserLogOut", true)
        startActivity(intent)
        finish()
    }
}
