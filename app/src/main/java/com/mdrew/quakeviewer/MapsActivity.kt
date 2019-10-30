package com.mdrew.quakeviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback  {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val quake = LatLng(
            intent.extras.getDouble(resources.getString(R.string.lat_bundle_key)),
            intent.extras.getDouble(resources.getString(R.string.lng_bundle_key)))
        mMap.addMarker(MarkerOptions().position(quake).title(intent.extras.getString(resources.getString(R.string.title_bundle_key))))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(quake))
    }
}
