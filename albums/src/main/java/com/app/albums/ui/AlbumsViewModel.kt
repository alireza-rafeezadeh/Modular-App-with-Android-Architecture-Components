package com.app.albums.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.network.datasource.AlbumsDataSource
import com.app.network.cache.Listener
import com.app.network.cache.albums.Album
import javax.inject.Inject

class AlbumsViewModel  @Inject  constructor(val albumsDataSource: AlbumsDataSource) : ViewModel() {


    var albumsLiveData : MutableLiveData<List<Album>> = MutableLiveData()


    fun getAlbums(): LiveData<List<Album>> {

       return albumsDataSource.getAlbums(object :
           Listener<List<Album>> {
            override fun onResponse(response: List<Album>) {
                albumsLiveData.postValue(response)
            }
        })

    }

}