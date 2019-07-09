package com.app.network.api

import com.app.network.cache.photos.Photo
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */
interface PhotosApi {

    @GET("photos")
    fun getPhotos(): Call<List<Photo>>
}