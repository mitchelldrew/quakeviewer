package com.mdrew.quakeviewer

import com.mdrew.quakeviewer.rest.QuakeService

class ListPresenter(val quakeService: QuakeService, val schedulerProvider:ISchedulerProvider): IListPresenter{
    private lateinit var view:IListView

    override fun setView(view: IListView) {
        this.view = view
    }

    override fun getQuakes() {
        quakeService.getQuakes(
            formatted = true,
            north = 44.1,
            south = -9.8,
            east = -22.4,
            west = 55.2,
            username = "mkoppelman")
            .subscribeOn(schedulerProvider.newThread())
            .observeOn(schedulerProvider.mainThread())
            .subscribe {
                view.displayQuakes(it)
            }
    }

}