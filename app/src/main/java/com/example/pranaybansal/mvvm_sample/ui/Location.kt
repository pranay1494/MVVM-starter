package com.example.pranaybansal.mvvm_sample.ui

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.pranaybansal.mvvm_sample.R
import com.example.pranaybansal.mvvm_sample.databinding.ActivityLocationBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.analytics.FirebaseAnalytics



class Location :AppCompatActivity(){

    lateinit var client : FusedLocationProviderClient
    lateinit var binding: ActivityLocationBinding
    lateinit var mFirebaseAnalytics: FirebaseAnalytics

    private val REQUEST_PERMISSIONS_REQUEST_CODE: Int = 999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityLocationBinding>(this,R.layout.activity_location)
        client = LocationServices.getFusedLocationProviderClient(this)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    override fun onStart() {
        super.onStart()
        if (!checkPermissions()){
            requestPermissions()
        }else{
            getLastLocation()
        }

        mFirebaseAnalytics.setCurrentScreen(this,"Location-Tracker",null)
    }


    private fun checkPermissions() = ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) == PERMISSION_GRANTED


    private fun startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION), REQUEST_PERMISSIONS_REQUEST_CODE)
    }

    private fun requestPermissions() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, ACCESS_COARSE_LOCATION)) {
            startLocationPermissionRequest()

        } else {
            startLocationPermissionRequest()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE){
            when(grantResults[0]){
                PERMISSION_GRANTED -> getLastLocation()
                else -> startLocationPermissionRequest()
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        client.lastLocation.addOnCompleteListener { task ->
            task.result?.let {
                if (task.isSuccessful){
                    binding.lat.text = it.latitude.toString()
                    binding.textView2.text = it.longitude.toString()
                    Log.d("received location lat:",it.latitude.toString())
                }
            }
        }
    }
}