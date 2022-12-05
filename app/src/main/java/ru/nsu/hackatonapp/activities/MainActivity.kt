package ru.nsu.hackatonapp.activities

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import ru.nsu.hackatonapp.databinding.ActivityMainBinding
import ru.nsu.hackatonapp.utils.LogTags
import android.widget.Toast
import ru.nsu.hackatonapp.domain.viewmodels.LoginViewModel
import ru.nsu.hackatonapp.network.BaseResponse

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        askForPermission()
        loginViewModel.loginResult.observe(this) {
            when (it) {
                is BaseResponse.Loading -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                    Log.i(LogTags.LOGIN_TAG, "Logging ...")
                }
                is BaseResponse.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    Log.e(LogTags.LOGIN_TAG, "Error while logging. ${it.msg}")
                }
                is BaseResponse.Success -> {
                    Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show()
                    Log.i(LogTags.LOGIN_TAG, "Successfully logged in")
                }
                else -> {
                    Log.e(LogTags.LOGIN_TAG, "Unexpected error")
                }
            }
        }
        binding.loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val email = binding.loginEmail.text.toString()
        val password = binding.loginPassword.text.toString()
        loginViewModel.loginUser(email, password)
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