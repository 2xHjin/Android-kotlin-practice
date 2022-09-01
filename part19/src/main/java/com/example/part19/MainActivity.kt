package com.example.part19

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity() , GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback {
    lateinit var providerClient: FusedLocationProviderClient
    lateinit var apiClient:GoogleApiClient
    var googleMap: GoogleMap?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var requestPermissionLauncher=registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
        if(it.all { permission->permission.value==true}){
            apiClient.connect()
        }else{
            Toast.makeText(this,"권한거부",Toast.LENGTH_SHORT).show()
            }
        }

        (supportFragmentManager.findFragmentById(R.id.mapView) as
                SupportMapFragment?)!!.getMapAsync(this)

        providerClient= LocationServices.getFusedLocationProviderClient(this)
        apiClient=GoogleApiClient.Builder(this)
            .addApi(LocationServices.API)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .build()

        if(ContextCompat.checkSelfPermission(
                this,android.Manifest.permission.ACCESS_FINE_LOCATION)!==
                    PackageManager.PERMISSION_GRANTED||
            ContextCompat.checkSelfPermission(
                this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!==
            PackageManager.PERMISSION_GRANTED||
            ContextCompat.checkSelfPermission(
                this,android.Manifest.permission.ACCESS_NETWORK_STATE)!==
            PackageManager.PERMISSION_GRANTED){
            requestPermissionLauncher.launch(
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.ACCESS_NETWORK_STATE
                )
            )
        }else{
            apiClient.connect()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==100&&
                grantResults[0]==PackageManager.PERMISSION_GRANTED&&
            grantResults[1]==PackageManager.PERMISSION_GRANTED&&
            grantResults[2]==PackageManager.PERMISSION_GRANTED)
        {
            apiClient.connect()
        }
    }

    private fun moveMap(latitude:Double,longitude:Double){
        val latLng=LatLng(latitude,longitude)
        val position: CameraPosition =CameraPosition.Builder()
            .target(latLng)
            .zoom(16f)
            .build()

        
    }

    override fun onConnected(p0: Bundle?) {

    }

    override fun onConnectionSuspended(p0: Int) {
        TODO("Not yet implemented")
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("Not yet implemented")
    }

    override fun onMapReady(p0: GoogleMap?) {
        TODO("Not yet implemented")
    }
}