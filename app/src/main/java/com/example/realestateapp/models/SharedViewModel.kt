package com.example.realestateapp.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private var _listings = MutableLiveData<MutableList<Listing>>()
    val listings: LiveData<MutableList<Listing>> = _listings

    private var _listing = MutableLiveData<Listing>()
    val listing: LiveData<Listing> = _listing

    fun saveListings(newListings: MutableList<Listing>) {
        _listings.value = newListings
    }

    fun saveListing(newListing: Listing) {
        _listing.value = newListing
    }
}