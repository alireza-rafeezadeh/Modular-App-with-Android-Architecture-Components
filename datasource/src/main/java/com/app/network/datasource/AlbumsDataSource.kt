package com.app.network.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import com.app.network.NetworkClient
import com.app.network.api.AlbumsApi
import com.app.network.cache.Listener
import com.app.network.cache.albums.Album
import com.app.network.cache.albums.AlbumPersist
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by Alireza Rafeezadeh on 6/12/2019.
 */
class AlbumsDataSource @Inject constructor(
    private val networkClient: NetworkClient<AlbumsApi>,
    val albumPersist: AlbumPersist
) {


    fun getAlbums(listener: Listener<List<Album>>): LiveData<List<Album>> {

        networkClient.getRetrofitService(AlbumsApi::class.java).getAlbums().enqueue(object : Callback<List<Album>> {
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Log.d("response_posts", t.message)
            }

            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                response.body()?.let {
                    listener.onResponse(response = it)
                    GlobalScope.launch {
                        albumPersist.save(it)
                    }
                }
            }
        })

        return albumPersist.load()

    }

}