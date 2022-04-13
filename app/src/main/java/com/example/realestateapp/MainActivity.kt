package com.example.realestateapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.action_search -> {
                    // todo: navigate to the search screen
                    Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                }
                R.id.action_results -> {
                    // todo: navigate to the results screen
                    Toast.makeText(this, "Results", Toast.LENGTH_SHORT).show()
                }
                R.id.action_wishlist -> {
                    // todo: navigate to the wishlist screen
                    Toast.makeText(this, "Wishlist", Toast.LENGTH_SHORT).show()
                }
                R.id.action_signout -> {
                    // todo: navigate to the sign out screen
                    Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    fun startSearchActivity(view: View) {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }
}
