package com.example.realestateapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realestateapp.ListingAdapter
import com.example.realestateapp.R
import com.example.realestateapp.models.Listing
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery

class ResultsFragment : Fragment() {

    var allListings: MutableList<Listing> = mutableListOf()
    lateinit var rvListings: RecyclerView
    lateinit var adapter: ListingAdapter

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


//        queryListings()
    }

//    open fun queryListings() {
//        val query: ParseQuery<Listing> = ParseQuery.getQuery(Listing::class.java)
//        query.include(Listing.KEY_USER)
//        query.addDescendingOrder("createdAt")
//        query.setLimit(LIMIT)  // Return the 20 most recent listings
//
//        query.findInBackground(object : FindCallback<Listing> {
//            override fun done(listings: MutableList<Listing>?, e: ParseException?) {
//                if (e != null) {
//                    // Something went wrong
//                    Log.e(TAG, "Error fetching listings")
//                } else {
//                    if (listings != null) {
//                        allListings.addAll(listings)
//                        adapter.notifyDataSetChanged()
//                    }
//                }
//            }
//        })
//    }

    companion object {
        const val TAG = "ResultsFragment"
        const val LIMIT = 20
    }
}