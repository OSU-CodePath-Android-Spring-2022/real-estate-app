package com.example.realestateapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.realestateapp.models.Listing

class ListingAdapter(val context: Context, val listings: MutableList<Listing>)
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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
        }

        fun bind(listing: Listing) {
            Glide.with(itemView.context).load(listing.primaryPhoto).into(ivListingPhoto)
            tvPrice.text = "$" + listing.listPrice.toString()
            tvBedCount.text = listing.beds.toString() + "bds"
            tvBathCount.text = listing.baths.toString() + "ba"
            tvSqFt.text = listing.sqft.toString() + "sqft"
            tvAddress.text = listing.streetAddr + ", " + listing.city + ", " + listing.stateCode
        }
    }
}