package com.mdrew.quakeviewer

class ListPresenter(): IListPresenter{
    private lateinit var view:IListView

    override fun setView(view: IListView) {
        this.view = view
    }

}