package com.mdrew.quakeviewer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.mdrew.quakeviewer.model.Quake
import com.mdrew.quakeviewer.model.QuakeResponse
import javax.inject.Inject

class ListActivity : AppCompatActivity(), IListView, AdapterView.OnItemClickListener {

    @Inject
    lateinit var presenter: IListPresenter
    private lateinit var list: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        findViews()
        QuakeApplication.graph.inject(this)
        presenter.setView(this)
    }

    private fun findViews(){
        list = findViewById(R.id.quake_list)
    }

    override fun onResume() {
        super.onResume()
        presenter.getQuakes()
    }


    override fun displayQuakes(response: QuakeResponse) {
        list.adapter = QuakeArrayAdapter(response.earthquakes, this)
        list.invalidate()
        list.onItemClickListener = this
    }


    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val adapter = list.adapter as QuakeArrayAdapter
        handleClick(adapter.quakes[p2])
    }

    private fun handleClick(quake:Quake){
        val i = Intent(this, MapsActivity::class.java)
        val bundle = Bundle()
        bundle.putDouble(resources.getString(R.string.lat_bundle_key),quake.lat)
        bundle.putDouble(resources.getString(R.string.lng_bundle_key),quake.lng)
        bundle.putString(resources.getString(R.string.title_bundle_key),quake.datetime)
        i.putExtras(bundle)
        startActivity(i)
    }
}