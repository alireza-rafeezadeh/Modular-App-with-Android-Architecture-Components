package com.app.modular.base.builder

import com.app.albums.base.AlbumsFragmentBuilder
import com.app.modular.main.MainActivity
import com.app.photos.base.PhotosFragmentBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Alireza Rafeezadeh on 6/1/2019.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            AlbumsFragmentBuilder::class,
            PhotosFragmentBuilder::class,
            AlbumsViewModelBuilder::class,
            PhotosViewModelBuilder::class
        ]
    )

    internal abstract fun bindMainActivity(): MainActivity

}