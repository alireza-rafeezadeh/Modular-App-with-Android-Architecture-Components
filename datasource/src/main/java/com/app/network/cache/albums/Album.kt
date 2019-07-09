package com.app.network.cache.albums

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Alireza Rafeezadeh on 6/12/2019.
 */

@Entity
data class Album(

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    val id: Int,


    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("userId")
    @Expose
    val userId: Int




)


