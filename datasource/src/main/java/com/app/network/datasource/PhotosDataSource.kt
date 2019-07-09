package com.app.network.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import com.app.network.NetworkClient
import com.app.network.api.PhotosApi
import com.app.network.cache.Listener
import com.app.network.cache.photos.Photo
import com.app.network.cache.photos.PhotoPersist
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */
class PhotosDataSource @Inject constructor(val networkClient : NetworkClient<PhotosApi>, val photoPersist : PhotoPersist) {


    fun getPhotos(listener: Listener<List<Photo>>): LiveData<List<Photo>> {

        networkClient.getRetrofitService(PhotosApi::class.java).getPhotos().enqueue(object : Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.d("response_posts", t.message)
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                response.body()?.let {
                    listener.onResponse(response = it)
                    GlobalScope.launch {
                        photoPersist.save(it)
                    }
                }
            }
        })

        return photoPersist.load()
    }

}