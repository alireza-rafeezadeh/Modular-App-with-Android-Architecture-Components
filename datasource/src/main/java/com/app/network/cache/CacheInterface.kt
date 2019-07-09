package com.app.network.cache

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

/**
 * Created by Alireza Rafeezadeh on 6/15/2019.
 */
interface CacheInterface<V> {


    @WorkerThread
    suspend fun  save(items : List<V>)

     fun  load() : LiveData<List<V>>

}