package com.app.photos.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigator
import com.app.network.datasource.PhotosDataSource
import com.app.network.cache.Listener
import com.app.network.cache.photos.Photo
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */
class PhotosViewModel @Inject  constructor(private val photosDataSource: PhotosDataSource) : ViewModel() {


    var photosLiveData : MutableLiveData<List<Photo>> = MutableLiveData()


    fun getPhotos() : LiveData<List<Photo>>{
        return photosDataSource.getPhotos(object :
            Listener<List<Photo>> {
            override fun onResponse(response: List<Photo>) {
                photosLiveData.postValue(response)
            }

        })

    }


}