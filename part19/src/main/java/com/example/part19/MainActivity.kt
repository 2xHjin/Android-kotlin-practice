package com.example.part19

import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback

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

    }
}