package ru.nsu.hackatonapp.activities

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import ru.nsu.hackatonapp.databinding.ActivityMainBinding
import ru.nsu.hackatonapp.domain.Login
import ru.nsu.hackatonapp.utils.LogTags
import android.view.View
import android.widget.Toast
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val loginViewModel: Login by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        askForPermission()
        binding.loginButton.setOnClickListener{
            coroutineScope{
                launch {
                    val login = Login()
                }
            }
            Toast.makeText(this, "asd", Toast.LENGTH_SHORT).show()
        }
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