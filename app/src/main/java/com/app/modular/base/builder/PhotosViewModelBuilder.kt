package com.app.modular.base.builder

import androidx.lifecycle.ViewModel
import com.app.photos.ui.photos.PhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */
@Module
abstract class PhotosViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: PhotosViewModel): ViewModel


}