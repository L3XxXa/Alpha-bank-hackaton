package ru.nsu.googledevelopmentguide

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import ru.nsu.googledevelopmentguide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            findMyLocation()
        }

        //Запрос разрешения на предоставление локации
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    Toast.makeText(this, "You granted permission", Toast.LENGTH_SHORT).show()
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    Toast.makeText(this, "You granted permission", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "You didn't grant a permission", Toast.LENGTH_SHORT).show()
                }
            }
        }
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
        //Location center instance

    }

    private fun findMyLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener {
                Log.i("location", "$it")
                Toast.makeText(this, "${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
            }
        fusedLocationClient.getCurrentLocation(PRIORITY_HIGH_ACCURACY, object : CancellationToken(){
            override fun onCanceledRequested(p0: OnTokenCanceledListener): CancellationToken {
                return CancellationTokenSource().token
            }

            override fun isCancellationRequested(): Boolean {
                return false
            }
        }).addOnSuccessListener {
            if (it == null){
                Toast.makeText(this, "Can't get your location", Toast.LENGTH_SHORT).show()
                Log.e("Location", "Location is null")
            }
            else{
                Toast.makeText(this, "Current location ${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
                Log.i("Location", "Current location $it")
            }
        }
    }
}