package com.example.realestateapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.realestateapp.R
import com.example.realestateapp.models.SharedViewModel


class DetailsFragment: Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate the layout for the details fragment
        return inflater.inflate(R.layout.details_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.listings.observe(viewLifecycleOwner) {}
    }
}
