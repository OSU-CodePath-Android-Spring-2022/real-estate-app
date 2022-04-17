package com.example.realestateapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.example.realestateapp.R
import com.example.realestateapp.models.SharedViewModel

class WishlistFragment : Fragment() {

    lateinit var etCityText: EditText
    lateinit var btnTest2: Button

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wishlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etCityText = view.findViewById(R.id.etCityText)
        btnTest2 = view.findViewById(R.id.btnTest2)

        sharedViewModel.city.observe(viewLifecycleOwner, { city ->
            etCityText.setText(city)
        })

        btnTest2.setOnClickListener {
            sharedViewModel.saveCity(etCityText.text.toString())
        }
    }
}