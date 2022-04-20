package com.example.realestateapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realestateapp.ListingAdapter
import com.example.realestateapp.R
import com.example.realestateapp.models.Listing
import com.example.realestateapp.models.SharedViewModel
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery

class ResultsFragment : Fragment() {

    lateinit var rvListings: RecyclerView
    lateinit var adapter: ListingAdapter
    var allListings: MutableList<Listing> = mutableListOf()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.rvListings)

        rvListings = view.findViewById(R.id.rvListings)
        adapter = ListingAdapter(requireContext(), allListings)
        rvListings.adapter = adapter
        rvListings.layoutManager = LinearLayoutManager(requireContext())

        sharedViewModel.listings.observe(viewLifecycleOwner) { listings ->
            adapter.clear()
            adapter.addAll(listings)
        }
    }

    companion object {
        const val TAG = "ResultsFragment"
        const val LIMIT = 20
    }
}