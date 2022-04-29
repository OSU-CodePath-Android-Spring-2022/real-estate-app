package com.example.realestateapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.realestateapp.R
import com.example.realestateapp.models.SharedViewModel


class DetailsFragment: Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    lateinit var tvPrice: TextView
    lateinit var tvBedRooms: TextView
    lateinit var tvBathRooms: TextView
    lateinit var tvAdditionalInfo: TextView
    lateinit var MainPhoto: ImageView
    lateinit var descriptionJson =  descriptionJson.getJSONobject


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate the layout for the details fragment
        return inflater.inflate(R.layout.details_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.listing.observe(viewLifecycleOwner) { listing ->
            MainPhoto = view.findViewById(R.id.MainPhoto)
            // get photo
            tvPrice = view.findViewById(R.id.tvPrice)
            tvPrice.text = listing.listPrice.toString()
            tvBedRooms = view.findViewById(R.id.tvBedRooms)
            tvBedRooms.text = listing.beds.toString()
            tvBathRooms = view.findViewById(R.id.tvBathRooms)
            tvBathRooms.text = listing.baths.toString()
            tvAdditionalInfo = view.findViewById(R.id.tvAdditionalInfo)
            // tvAdditionalInfo.text = listingJson.getJSONObject("description")
            // this is where the information is beyond the current json parse

        }
    }
}
