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
import java.util.*


class DetailsFragment: Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    lateinit var tvPrice: TextView
    lateinit var tvBedRooms: TextView
    lateinit var tvBathRooms: TextView
    lateinit var tvPropertyID: TextView
    lateinit var MainPhoto: ImageView
    lateinit var tvYearBuilt: TextView
    lateinit var tvSquareFoot: TextView
    lateinit var tvLotSize: TextView
    lateinit var tvHomeType: TextView
    lateinit var tvPostCode: TextView
    lateinit var tvStateCode: TextView
    lateinit var tvStreetAddr: TextView
    lateinit var tvCity: TextView


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
            tvPrice = view.findViewById(R.id.tvPrice)
            tvPrice.text = "$" + listing.listPrice.toString()
            tvBedRooms = view.findViewById(R.id.tvBedRooms)
            tvBedRooms.text = listing.beds.toString() + " Br"
            tvBathRooms = view.findViewById(R.id.tvBathRooms)
            tvBathRooms.text = listing.baths.toString() + " Ba"
            tvPropertyID = view.findViewById(R.id.tvPropertyID)
            tvPropertyID.text = "Listing ID: " + listing.propertyID.toString()
            tvYearBuilt = view.findViewById(R.id.tvYearBuilt)
            tvYearBuilt.text = "Year Built: " + listing.yearBuilt.toString()
            tvSquareFoot = view.findViewById(R.id.tvSquareFoot)
            tvSquareFoot.text = "Square Footage: " + listing.sqft.toString()
            tvLotSize = view.findViewById(R.id.tvLotSize)
            tvLotSize.text = "Lot Size: " + listing.lotSqft.toString()
            tvHomeType = view.findViewById(R.id.tvHomeType)
            tvHomeType.text = "Home Type: " + listing.type.toString()
            tvPostCode = view.findViewById(R.id.tvPostCode)
            tvPostCode.text = listing.postalCode.toString()
            tvStateCode = view.findViewById(R.id.tvStateCode)
            tvStateCode.text = listing.stateCode.toString()
            tvStreetAddr = view.findViewById(R.id.tvStreetAddr)
            tvStreetAddr.text = listing.streetAddr.toString()
            tvCity = view.findViewById(R.id.tvCity)
            tvCity.text = listing.city.toString()


        }
    }
}
