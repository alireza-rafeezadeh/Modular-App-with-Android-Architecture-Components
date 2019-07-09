package com.app.modular.base


import com.app.modular.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Alireza Rafeezadeh on 5/20/2019.
 */

@Subcomponent
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}