package com.example.realestateapp

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.realestateapp.fragments.WishlistFragment
import com.example.realestateapp.models.Listing
import com.example.realestateapp.models.SharedViewModel
import com.parse.ParseUser
import java.util.*


open class WishlistAdapter(val context: Context, val listings: MutableList<Listing>, val sharedViewModel: SharedViewModel)
    : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishlistAdapter.ViewHolder, position: Int) {
        val listing = listings.get(position)
        holder.bind(listing)
    }

    override fun getItemCount(): Int {
        return listings.size
    }

    fun clear() {
        listings.clear()
        notifyDataSetChanged()
    }

    fun addAll(listingList: MutableList<Listing>) {
        listings.addAll(listingList)
        notifyDataSetChanged()
    }

    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnLongClickListener {
        val ivListingPhoto: ImageView
        val tvPrice: TextView
        val tvBedCount: TextView
        val tvBathCount: TextView
        val tvSqFt: TextView
        val tvAddress: TextView
        val btnRemove: Button

        init {
            ivListingPhoto = itemView.findViewById(R.id.ivListingPhotoW)
            tvPrice = itemView.findViewById(R.id.tvPriceW)
            tvBedCount = itemView.findViewById(R.id.tvBedCountW)
            tvBathCount = itemView.findViewById(R.id.tvBathCountW)
            tvSqFt = itemView.findViewById(R.id.tvSqFtW)
            tvAddress = itemView.findViewById(R.id.tvAddressW)


            itemView.setOnLongClickListener(this)
            btnRemove = itemView.findViewById(R.id.btnRemove)
            btnRemove.setOnClickListener {
                removeFromWishlist()
            }
        }

        fun bind(listing: Listing) {
            Glide.with(itemView.context).load(listing.primaryPhoto)
                .error(ColorDrawable(Color.LTGRAY)).into(ivListingPhoto)
            tvPrice.text = "$" + String.format("%,d", listing.listPrice)
            tvBedCount.text = listing.beds.toString() + " bds"
            tvBathCount.text = listing.baths.toString() + " ba"
            tvSqFt.text = listing.sqft.toString() + " sqft"
            tvAddress.text = listing.streetAddr + ", " + listing.city + ", " + listing.stateCode

            // Display null data as N/A
            val parameterList = listOf(listing.beds, listing.baths, listing.sqft)
            val textViewList = listOf(tvBedCount, tvBathCount, tvSqFt)
            val unitList = listOf(" bds", " ba", " sqft")

            for (i in 0 until parameterList.size) {
                if (parameterList[i] == -1) {
                    textViewList[i].text = unitList[i] + " N/A"
                }
            }
        }

        override fun onLongClick(v: View): Boolean {
            // 1. Get notified of the particular movie which was clicked
            val listing = listings[adapterPosition]

            // 2. Use the intent system to navigate to the new activity
            sharedViewModel.saveListing(listings[adapterPosition])
            return true
        }

        private fun removeFromWishlist() {
            val property = listings[adapterPosition]
            var position = -1
            val user = ParseUser.getCurrentUser()
            val wishlistJson = user.getJSONArray("wishlist")
            if (wishlistJson != null) {
                for (i in 0 until wishlistJson.length()) {
                    if (wishlistJson.getString(i) == property.propertyID) {
                        position = i
                    }
                }
                wishlistJson.remove(position)
                user.put("wishlist", wishlistJson)
                user.saveInBackground()
                listings.removeAt(adapterPosition)
                notifyDataSetChanged()
            }
        }
    }
}