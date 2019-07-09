package com.app.network.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.network.cache.albums.Album
import com.app.network.cache.albums.AlbumDao
import com.app.network.cache.photos.Photo
import com.app.network.cache.photos.PhotoDao


/**
 * Created by Alireza Rafeezadeh on 6/12/2019.
 */


@Database(entities = [Album::class, Photo::class], version = 1)
abstract class MainDatabase : RoomDatabase() {


    abstract fun postDao(): AlbumDao

    abstract fun photoDao(): PhotoDao


    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "MainDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}
