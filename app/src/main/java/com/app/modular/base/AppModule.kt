package com.app.modular.base

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Alireza Rafeezadeh on 6/1/2019.
 */


@Module(subcomponents = [MainActivityComponent::class])
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }


}
