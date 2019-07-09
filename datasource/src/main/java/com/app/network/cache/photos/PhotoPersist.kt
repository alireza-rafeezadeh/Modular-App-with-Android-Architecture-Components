package com.app.network.cache.photos

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.app.network.cache.CacheInterface
import com.app.network.cache.MainDatabase
import javax.inject.Inject

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */
class PhotoPersist @Inject constructor(val context: Context) :
    CacheInterface<Photo> {

    var photoDao: PhotoDao = MainDatabase.getDatabase(context).photoDao()

    @WorkerThread
    override suspend fun save(items: List<Photo>) {
        photoDao.save(items)
    }

    override fun load(): LiveData<List<Photo>> {
        return photoDao.load()
    }


}