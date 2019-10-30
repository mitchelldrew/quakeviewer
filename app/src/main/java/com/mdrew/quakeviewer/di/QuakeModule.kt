package com.mdrew.quakeviewer.di

import android.content.Context
import com.mdrew.quakeviewer.QuakeApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class QuakeModule(private val application: QuakeApplication){

    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(): Context{
        return application
    }


}