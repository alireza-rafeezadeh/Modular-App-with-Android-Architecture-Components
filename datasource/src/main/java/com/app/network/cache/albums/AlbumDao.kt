package com.app.network.cache.albums

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Alireza Rafeezadeh on 6/12/2019.
 */

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(albums: List<Album>)

    @Query("SELECT * FROM album")
    fun load(): LiveData<List<Album>>

}