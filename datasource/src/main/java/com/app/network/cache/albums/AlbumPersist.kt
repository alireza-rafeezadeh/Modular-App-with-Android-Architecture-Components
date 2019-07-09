package com.app.network.cache.albums

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.app.network.cache.CacheInterface
import com.app.network.cache.MainDatabase
import javax.inject.Inject

/**
 * Created by Alireza Rafeezadeh on 6/12/2019.
 */
class AlbumPersist @Inject constructor(val context: Context) :
    CacheInterface<Album> {

    private var albumDao: AlbumDao = MainDatabase.getDatabase(context).postDao()

    @WorkerThread
    override suspend fun save(items: List<Album>) {
        albumDao.save(items)
    }

    override  fun load(): LiveData<List<Album>> {
        return albumDao.load()
    }

}