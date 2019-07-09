package com.app.network.cache

/**
 * Created by Alireza Rafeezadeh on 6/15/2019.
 */
interface Listener<T> {

    fun onResponse(response : T)
}