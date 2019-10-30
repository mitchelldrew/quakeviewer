package com.mdrew.quakeviewer

import android.app.Application
import com.mdrew.quakeviewer.di.ApplicationComponent

class QuakeApplication: Application() {

    companion object{
        @JvmStatic
        lateinit var graph:ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
    }

}