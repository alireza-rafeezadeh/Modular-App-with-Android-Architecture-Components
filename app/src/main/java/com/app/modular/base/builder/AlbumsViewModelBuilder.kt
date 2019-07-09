package com.app.modular.base.builder

import androidx.lifecycle.ViewModel
import com.app.albums.ui.AlbumsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Alireza Rafeezadeh on 7/8/2019.
 */
@Module
abstract class AlbumsViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(AlbumsViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: AlbumsViewModel): ViewModel



}