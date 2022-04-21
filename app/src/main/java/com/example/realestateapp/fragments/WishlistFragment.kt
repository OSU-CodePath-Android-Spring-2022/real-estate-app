package com.example.realestateapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
//import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realestateapp.ListingAdapter
import com.example.realestateapp.ParseListing
import com.example.realestateapp.R
import com.example.realestateapp.models.Listing
import com.example.realestateapp.models.SharedViewModel
import com.parse.*
import java.util.*


class WishlistFragment : Fragment() {

    fun queryWishlist() {
        val user = ParseUser.getCurrentUser()
        val wishlist = user.getJSONArray("wishlist")
        Log.i("wishlist test", wishlist.toString())
//        val query: ParseQuery<ParseObject> = ParseQuery.getQuery("Listing")
//        query.whereContainedIn("listingId", wishlist)
//        query.findInBackground(object : FindCallback<ParseObject> {
//            override fun done(listings: MutableList<ParseObject>?, e: ParseException?) {
//                if (e != null) {
//                    Log.e("wishlist", "Error fetching posts")
//                } else {
//                    if (listings != null) {
//                        for (listing in listings) {
//                            Log.i("listing", listing.getInt("listPrice").toString())
//                        }
//                    }
//                }
//            }
//        })

    }


//    lateinit var rvWishlist: RecyclerView
//    lateinit var adapter: ListingAdapter
//    var wishlist: MutableList<Listing> = mutableListOf()
//    private val sharedViewModel: SharedViewModel by activityViewModels()
//
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wishlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        queryWishlist()
//        view.findViewById<RecyclerView>(R.id.rvWishlist)

//        rvWishlist = view.findViewById(R.id.rvWishlist)
//        adapter = ListingAdapter(requireContext(),wishlist)
//        rvWishlist.adapter = adapter
//        rvWishlist.layoutManager = LinearLayoutManager(requireContext())
//         get user's wishlist

//        sharedViewModel.listings.observe(viewLifecycleOwner) {}
    }
}