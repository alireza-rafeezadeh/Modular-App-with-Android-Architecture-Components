/*
 * Copyright (c) 2018.
 * All rights reserved for Pipedrive
 */

package com.app.modular.base.builder.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}