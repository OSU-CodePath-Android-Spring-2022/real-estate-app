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
import com.example.realestateapp.MainActivity
import com.example.realestateapp.R
import com.example.realestateapp.models.Listing
import com.example.realestateapp.models.SharedViewModel
import okhttp3.Headers
import org.json.JSONException

class SearchFragment : Fragment() {
    private val client = AsyncHttpClient()
    private val headers = RequestHeaders()
    private val listings = mutableListOf<Listing>()

    lateinit var etSearchQuery: EditText
    lateinit var btnTest: Button

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

        etSearchQuery = view.findViewById(R.id.etSearchQuery)
        btnTest = view.findViewById(R.id.btnTest)

        sharedViewModel.city.observe(viewLifecycleOwner, { city ->
            etSearchQuery.setText(city)
        })

        btnTest.setOnClickListener {
            sharedViewModel.saveCity(etSearchQuery.text.toString())
        }

        view.findViewById<Button>(R.id.btnSearch).setOnClickListener {
            getSearchResults()
        }

        headers.put("X-RapidAPI-Host", getString(R.string.rapid_api_host))
        headers.put("X-RapidAPI-Key", getString(R.string.rapid_api_key))
    }

    private fun getSearchResults() {
        val params = RequestParams()
        params.put("offset", "0")
        params.put("limit", "42")
        params.put("state_code", "MI")
        params.put("city", "Detroit")
        params.put("sort", "newest")
        params.put("property_type", "multi_family,single_family")

        client.get(getString(R.string.rapid_api_endpoint), headers, params, object: JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                Log.i(TAG, "onSuccess: JSON data $json")
                try {
                    val dataJson = json.jsonObject.getJSONObject("data")
                    val listingJsonArray = dataJson.getJSONObject("home_search").getJSONArray("results")
                    listings.addAll(Listing.fromJsonArray(listingJsonArray))
                    Log.i(TAG, "Listing list $listings")
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