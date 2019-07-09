package com.app.photos.ui.photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.network.cache.photos.Photo
import com.app.photos.R

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */

class PhotosRVAdapter(val photos: List<Photo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return ItemViewHolder(itemView = view)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).albumIdTextView.text = photos[position].albumId.toString()
        holder.albumTitleTextView.text = photos[position].title
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val albumIdTextView: TextView = itemView.findViewById(R.id.albumIdTextView)
        val albumTitleTextView: TextView = itemView.findViewById(R.id.albumTitleTextView)
    }

}