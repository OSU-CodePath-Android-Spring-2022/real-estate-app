package com.example.realestateapp.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private var _city = MutableLiveData("Chicago")
    val city: LiveData<String> = _city

    fun saveCity(newCity: String) {
        _city.value = newCity
    }
}