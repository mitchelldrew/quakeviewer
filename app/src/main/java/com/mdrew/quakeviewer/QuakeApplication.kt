package com.mdrew.quakeviewer

import android.app.Application
import com.mdrew.quakeviewer.di.ApplicationComponent
import com.mdrew.quakeviewer.di.DaggerApplicationComponent
import com.mdrew.quakeviewer.di.QuakeModule

class QuakeApplication: Application() {

    companion object{
        @JvmStatic
        lateinit var graph:ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder().quakeModule(QuakeModule(this)).build()
    }

}