package com.app.network

import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Alireza Rafeezadeh on 6/12/2019.
 */


class NetworkClient<T> @Inject constructor(val retrofit: Retrofit) {


    fun getRetrofitService(interfaceTyoe : Class<T>) : T {
        return retrofit.create(interfaceTyoe)
    }



}