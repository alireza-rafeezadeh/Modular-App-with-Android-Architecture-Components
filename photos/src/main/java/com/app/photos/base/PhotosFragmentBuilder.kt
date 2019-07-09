package com.app.photos.base

import com.app.photos.ui.photos.PhotosFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */

@Module
abstract class PhotosFragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindMoviesListFragment(): PhotosFragment

}