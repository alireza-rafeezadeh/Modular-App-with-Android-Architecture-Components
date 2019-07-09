package com.app.network.cache.photos

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */

@Entity
data class Photo(


    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    val id: Int,


    @SerializedName("albumId")
    @Expose
    val albumId: Int,


    @SerializedName("thumbnailUrl")
    @Expose
    val thumbnailUrl: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("url")
    @Expose
    val url: String
)