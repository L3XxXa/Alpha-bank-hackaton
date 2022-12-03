package ru.nsu.hackatonapp.activities

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.utils.LogTags

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        askForPermission()
    }

    private fun askForPermission() {
        Log.i(LogTags.PERMISSION_TAG, "Asking for permission")
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    Log.i(LogTags.PERMISSION_TAG, "Granted permission for location")
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    Log.i(LogTags.PERMISSION_TAG, "Granted permission for location")
                }
                permissions.getOrDefault(Manifest.permission.CAMERA, false) -> {
                    Log.i(LogTags.PERMISSION_TAG, "Granted permission for camera")
                }
                else -> {
                }
            }
        }
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.CAMERA
            )
        )
    }
}