package com.example.realestateapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListingAdapter(val context: Context, val listings: List<Listing>)
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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
            Glide.with(itemView.context).load(listing.getImage()?.url).into(ivListingPhoto)
            tvPrice.text = listing.getPrice()
            tvBedCount.text = listing.getBedCount()
            tvBathCount.text = listing.getBathCount()
            tvSqFt.text = listing.getSqFt()
            tvAddress.text = listing.getAddress()
        }
    }
}