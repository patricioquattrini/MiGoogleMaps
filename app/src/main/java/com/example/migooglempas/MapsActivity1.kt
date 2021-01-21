package com.example.migooglempas

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.properties.Delegates
import kotlin.reflect.typeOf

class MapsActivity1 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var geocoder: Geocoder
    var lat by Delegates.notNull<Double>()
    var lon by Delegates.notNull<Double>()
    lateinit var ubication: String

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps1)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        geocoder = Geocoder(this)
        ubication = getAddres().toString()
        var res = geocoder.getFromLocationName(ubication,4)
        lat = -38.416097
        lon = -63.616672

        if (res.size != 0){
            lat = res[0].getLatitude()
            lon = res[0].getLongitude()

        }else{
            println("Entre en el else")
            ubication = "Argentina"
            Toast.makeText(this,"Ubicación no encontrada. Ingresa una dirección mas especifica como su país.", Toast.LENGTH_LONG).show()
        }
    }


    fun getAddres(): Any? {
        val ubi = intent.extras
        return ubi?.get("INTENT_UBI")
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val latYlon = LatLng(lat, lon)
        mMap.addMarker(MarkerOptions().position(latYlon).title(ubication))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latYlon))

    }
}