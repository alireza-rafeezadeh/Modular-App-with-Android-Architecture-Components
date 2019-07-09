package com.app.network.api


import com.app.network.cache.albums.Album
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by Alireza Rafeezadeh on 5/15/2019.
 */
interface AlbumsApi {

    @GET("albums")
    fun getAlbums(): Call<List<Album>>
}