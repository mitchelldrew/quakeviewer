package com.mdrew.quakeviewer

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mdrew.quakeviewer.model.QuakeResponse
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

    override fun onResume() {
        super.onResume()
        presenter.getQuakes()
    }


    override fun displayQuakes(response: QuakeResponse) {
        Log.v("rwr", "response: $response")
    }
}