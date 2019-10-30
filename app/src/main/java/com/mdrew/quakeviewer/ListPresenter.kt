package com.mdrew.quakeviewer

import com.mdrew.quakeviewer.rest.QuakeService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListPresenter(val quakeService: QuakeService): IListPresenter{
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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.displayQuakes(it)
            }
    }

}