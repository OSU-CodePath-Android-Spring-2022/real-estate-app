package com.example.realestateapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONArray
import org.json.JSONObject

@Parcelize
data class Listing(
    var propertyID: String,
    var primaryPhoto: String,
    var photos: MutableList<String> = mutableListOf(),
    var listPrice: Int,
    var yearBuilt: Int,
    var baths: Int,
    var stories: Int,
    var beds: Int,
    var type: String,
    var sqft: Int,
    var lotSqft: Int,
    var postalCode: String,
    var city: String,
    var stateCode: String,
    var streetAddr: String
): Parcelable {
    companion object {
        fun fromJsonArray(jsonArray: JSONArray): List<Listing> {
            val listings = mutableListOf<Listing>()
            for (i in 0 until jsonArray.length()) {
                val listingJson = jsonArray.getJSONObject(i)
                listings.add(parseListingJson(listingJson))
            }
            return listings
        }

        fun parseListingJson(listingJson: JSONObject): Listing {
            val descriptionJson = listingJson.getJSONObject("description")
            val addressJson = listingJson.getJSONObject("location").getJSONObject("address")
            return Listing (
                listingJson.getString("property_id"),
                listingJson.getJSONObject("primary_photo").getString("href"),
                parsePhotosJsonArray(listingJson.getJSONArray("photos")),
                listingJson.getInt("list_price"),
                descriptionJson.getInt("year_built"),
                descriptionJson.getInt("baths"),
                descriptionJson.getInt("stories"),
                descriptionJson.getInt("beds"),
                descriptionJson.getString("type"),
                descriptionJson.getInt("sqft"),
                descriptionJson.getInt("lot_sqft"),
                addressJson.getString("postal_code"),
                addressJson.getString("city"),
                addressJson.getString("state_code"),
                addressJson.getString("line")
            )
        }

        fun parsePhotosJsonArray(jsonArray: JSONArray): MutableList<String> {
            val photos = mutableListOf<String>()
            for (i in 0 until jsonArray.length()) {
                val photoJson = jsonArray.getJSONObject(i)
                photos.add(photoJson.getString("href"))
            }
            return photos
        }
    }
}
