package com.app.network.cache.photos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */
@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(posts: List<Photo>)

    @Query("SELECT * FROM photo")
    fun load(): LiveData<List<Photo>>
}