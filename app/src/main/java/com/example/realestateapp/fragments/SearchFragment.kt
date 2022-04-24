package com.example.realestateapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestHeaders
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.realestateapp.R
import com.example.realestateapp.models.Listing
import com.example.realestateapp.models.SharedViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import okhttp3.Headers
import org.json.JSONException


class SearchFragment : Fragment() {
    private val client = AsyncHttpClient()
    private val listings = mutableListOf<Listing>()

    lateinit var etState: EditText
    lateinit var etCity: EditText
    lateinit var btnSearch: Button

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etState = view.findViewById(R.id.etState)
        etCity = view.findViewById(R.id.etCity)
        btnSearch = view.findViewById(R.id.btnSearch)

        btnSearch.setOnClickListener {
            getSearchResults()
        }
    }

    private fun getSearchResults() {
        val headers = RequestHeaders()
        headers.put("X-RapidAPI-Host", getString(R.string.rapid_api_host))
        headers.put("X-RapidAPI-Key", getString(R.string.rapid_api_key))

        val params = RequestParams()
        params.put("city", etCity.text.toString())
        params.put("state_code", etState.text.toString())
        params.put("offset", "0")
        params.put("limit", "42")
        params.put("sort", "newest")
        params.put("property_type", "multi_family,single_family")

        client.get(getString(R.string.rapid_api_endpoint), headers, params, object: JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                Log.i(TAG, "onSuccess: JSON data $json")
                try {
                    // Parse JSON result into Listing objects and save to ViewModel mutable list
                    val dataJson = json.jsonObject.getJSONObject("data")
                    val listingJsonArray = dataJson.getJSONObject("home_search").getJSONArray("results")
                    listings.addAll(Listing.fromJsonArray(listingJsonArray))
                    sharedViewModel.saveListings(listings)
                    sharedViewModel.onLoadSuccess()
                    Log.i(TAG, "Listing list $listings")

                    // Swap to results screen
                    val transaction = parentFragmentManager.beginTransaction()
                    transaction.replace(R.id.flContainer, ResultsFragment())
                    transaction.commit()
                } catch (e: JSONException) {
                    Log.e(TAG, "Encountered exception $e")
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "onFailure $statusCode")
            }
        })
    }

    companion object {
        const val TAG = "SearchFragment"
    }
}