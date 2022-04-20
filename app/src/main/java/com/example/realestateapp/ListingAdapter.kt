package com.example.realestateapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.realestateapp.models.Listing
import com.example.realestateapp.models.SharedViewModel

class ListingAdapter(val context: Context, val listings: MutableList<Listing>, val sharedViewModel: SharedViewModel)
    : RecyclerView.Adapter<ListingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_listing, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListingAdapter.ViewHolder, position: Int) {
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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val ivListingPhoto: ImageView
        val tvPrice: TextView
        val tvBedCount: TextView
        val tvBathCount: TextView
        val tvSqFt: TextView
        val tvAddress: TextView

        init {
            ivListingPhoto = itemView.findViewById(R.id.ivListingPhoto)
            tvPrice = itemView.findViewById(R.id.tvPrice)
            tvBedCount = itemView.findViewById(R.id.tvBedCount)
            tvBathCount = itemView.findViewById(R.id.tvBathCount)
            tvSqFt = itemView.findViewById(R.id.tvSqFt)
            tvAddress = itemView.findViewById(R.id.tvAddress)


            itemView.setOnClickListener(this)
        }

        fun bind(listing: Listing) {
            Glide.with(itemView.context).load(listing.primaryPhoto).error(ColorDrawable(Color.LTGRAY)).into(ivListingPhoto)
            tvPrice.text = "$" + String.format("%,d", listing.listPrice)
            tvBedCount.text = listing.beds.toString() + " bds"
            tvBathCount.text = listing.baths.toString() + " ba"
            tvSqFt.text = listing.sqft.toString() + " sqft"
            tvAddress.text = listing.streetAddr + ", " + listing.city + ", " + listing.stateCode

        }

        override fun onClick(v: View?) {
            // 1. Get notified of the particular movie which was clicked
            val listing = listings[adapterPosition]

            // 2. Use the intent system to navigate to the new activity
            sharedViewModel.saveListing(listings[adapterPosition])
        }
    }
}