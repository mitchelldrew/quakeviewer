package com.mdrew.quakeviewer.di

import com.mdrew.quakeviewer.ListActivity
import com.mdrew.quakeviewer.MapsActivity
import com.mdrew.quakeviewer.QuakeApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [QuakeModule::class])
interface ApplicationComponent{
    fun inject(application: QuakeApplication)
    fun inject(listActivity: ListActivity)
    fun inject(mapsActivity: MapsActivity)
}