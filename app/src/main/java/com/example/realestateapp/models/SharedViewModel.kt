package com.example.realestateapp.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private var _listings = MutableLiveData<MutableList<Listing>>()
    val listings: LiveData<MutableList<Listing>> = _listings

    fun saveListings(newListings: MutableList<Listing>) {
        _listings.value = newListings
    }
}