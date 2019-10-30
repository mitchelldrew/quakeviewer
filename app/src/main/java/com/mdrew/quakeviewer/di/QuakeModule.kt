package com.mdrew.quakeviewer.di

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mdrew.quakeviewer.*
import com.mdrew.quakeviewer.rest.QuakeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    fun provideQuakeService(context: Context): QuakeService{
        val baseUrl = context.resources.getString(R.string.base_url)
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(QuakeService::class.java)

    }

    @Provides
    fun provideISchedulerProvider(): ISchedulerProvider {
        return SchedulerProvider()
    }

    @Provides
    fun provideIListPresenter(quakeService: QuakeService, schedulerProvider: ISchedulerProvider): IListPresenter {
        return ListPresenter(quakeService, schedulerProvider)
    }

}