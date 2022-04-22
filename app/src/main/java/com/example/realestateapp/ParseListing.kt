package com.example.realestateapp
import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser
import org.json.JSONArray
import kotlin.collections.ArrayList as ArrayList

@ParseClassName("Listing")
class ParseListing: ParseObject() {
    fun getListingId(): String? {
        return getString(KEY_LISTING_ID)
    }

    fun setListingId(listingId:String) {
        put(KEY_LISTING_ID, listingId )
    }

    fun getPrimPhoto(): String? {
        return getString(KEY_PRIM_PHOTO)
    }

    fun setPrimPhoto(primaryPhoto:String) {
        put(KEY_PRIM_PHOTO, primaryPhoto )
    }

    fun getPhotos(): JSONArray? {
        return getJSONArray(KEY_PHOTOS)
    }

    fun setPhotos(photos: MutableList<String>) {
        put(KEY_PHOTOS, photos )
    }

    fun getListPrice(): Int {
        return getInt(KEY_LIST_PRICE)
    }

    fun setListPrice(listPrice: Int) {
        put(KEY_LIST_PRICE, listPrice )
    }

    fun getYearBuilt(): Int {
        return getInt(KEY_YEAR_BUILT)
    }

    fun setYearBuilt(yearBuilt: Int) {
        put(KEY_YEAR_BUILT, yearBuilt)
    }

    fun getBaths(): Int {
        return getInt(KEY_BATHS)
    }

    fun setBaths(baths: Int) {
        put(KEY_BATHS, baths)
    }

    fun getStories(): Int {
        return getInt(KEY_STORIES)
    }

    fun setStories(stories: Int) {
        put(KEY_STORIES, stories)
    }

    fun getType(): String? {
        return getString(KEY_TYPE)
    }

    fun setType(type:String) {
        put(KEY_TYPE, type )
    }

    fun getBeds(): Int {
        return getInt(KEY_BEDS)
    }

    fun setBeds(beds: Int) {
        put(KEY_BEDS, beds)
    }

    fun getSqft(): Int {
        return getInt(KEY_SQFT)
    }

    fun setSqft(sqft: Int) {
        put(KEY_SQFT, sqft)
    }

    fun getLotSqft(): Int {
        return getInt(KEY_LOT_SQFT)
    }

    fun setLotSqft(lotSqft: Int) {
        put(KEY_LOT_SQFT, lotSqft)
    }

    fun getPostalCode(): String? {
        return getString(KEY_POSTAL_CODE)
    }

    fun setPostalCode(postalCode:String) {
        put(KEY_POSTAL_CODE, postalCode )
    }

    fun getCity(): String? {
        return getString(KEY_CITY)
    }

    fun setCity(city:String) {
        put(KEY_CITY, city)
    }

    fun getState(): String? {
        return getString(KEY_STATE)
    }

    fun setState(state:String) {
        put(KEY_STATE, state)
    }

    fun getStreet(): String? {
        return getString(KEY_STREET)
    }

    fun setStreet(streetAddr:String) {
        put(KEY_STREET, streetAddr)
    }

    companion object {
        const val KEY_LISTING_ID = "listingId"
        const val KEY_PRIM_PHOTO = "primaryPhoto"
        const val KEY_PHOTOS = "photos"
        const val KEY_LIST_PRICE = "listPrice"
        const val KEY_YEAR_BUILT = "yearBuilt"
        const val KEY_BATHS = "baths"
        const val KEY_STORIES = "stories"
        const val KEY_TYPE = "type"
        const val KEY_BEDS = "beds"
        const val KEY_SQFT = "sqft"
        const val KEY_LOT_SQFT = "lotSqft"
        const val KEY_POSTAL_CODE = "postalCode"
        const val KEY_CITY = "city"
        const val KEY_STATE = "stateCode"
        const val KEY_STREET = "streetAddr"

    }
}
