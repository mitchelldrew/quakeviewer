package com.mdrew.quakeviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class ListActivity : AppCompatActivity(), IListView{

    @Inject
    lateinit var presenter: IListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        findViews()
        QuakeApplication.graph.inject(this)
        presenter.setView(this)
    }

    private fun findViews(){

    }
}