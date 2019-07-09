package com.app.modular.main

import android.os.Bundle
import com.app.modular.R
import dagger.android.support.DaggerAppCompatActivity
import retrofit2.Retrofit

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
