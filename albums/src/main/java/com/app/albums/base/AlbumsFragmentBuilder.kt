package com.app.albums.base

import com.app.albums.ui.AlbumsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Alireza Rafeezadeh on 6/18/2019.
 */

@Module
abstract class AlbumsFragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindMoviesListFragment(): AlbumsFragment

}