package com.example.realestateapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

class DetailsFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainPhoto = findViewById(R.id.MainPhoto)
        tvPrice = findViewById(R.id.tvPrice)
        tvBedRooms = findViewById(R.id.tvBedRooms)
        tvBathRooms = findViewById(R.id.tvBathRooms)
        PhotoScroll = findViewById(R.id.PhotoScroll)
    }
}
