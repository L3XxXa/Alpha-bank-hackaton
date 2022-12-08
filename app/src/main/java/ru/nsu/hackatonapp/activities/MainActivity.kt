package ru.nsu.hackatonapp.activities

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.*
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import ru.nsu.hackatonapp.databinding.ActivityMainBinding
import ru.nsu.hackatonapp.utils.LogTags
import android.widget.Toast
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.domain.viewmodels.LoginViewModel
import ru.nsu.hackatonapp.network.BaseResponse
import ru.nsu.hackatonapp.utils.FieldValidators

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        askForPermission()
        loginObserver()
        binding.loginButton.setOnClickListener {
            login()
        }
        binding.registerButton.setOnClickListener{
            register()
        }
        binding.restorePswdLogin.setOnClickListener{
            restorePassword()
        }
    }

    private fun restorePassword() {
        val intent = Intent(this, RestorePasswordActivity::class.java)
        Log.d(LogTags.RESTORE_PSWD, "Starting restore password activity")
        startActivity(intent)
    }

    private fun register() {
        val intent = Intent(this, RegistrationActivity::class.java)
        Log.d(LogTags.REGISTRATION, "Starting registration activity")
        startActivity(intent)
    }

    private fun loginObserver() {
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
                    startCardsActivity()
                    Log.i(LogTags.LOGIN_TAG, "Successfully logged in")
                }
                else -> {
                    Log.e(LogTags.LOGIN_TAG, "Unexpected error")
                }
            }
        }
    }

    private fun startCardsActivity() {
        val intent = Intent(this, CardsActivity::class.java)
        startActivity(intent)
    }

    private fun login() {
        val email = binding.loginEmail.text.toString()
        val password = binding.loginPassword.text.toString()
        if (!FieldValidators.checkEmail(email)){
            displayError(binding.errorEmailLogin, getString(R.string.enter_valid_email))
            Log.e(LogTags.LOGIN_TAG, "Not email")
            if (!FieldValidators.checkPassword(password)){
                Log.e(LogTags.LOGIN_TAG, "Not password")
                displayError(binding.errorPswdLogin, getString(R.string.enter_password))
                return
            }
            return
        }
        binding.errorEmailLogin.visibility = INVISIBLE
        if (!FieldValidators.checkPassword(password)){
            Log.e(LogTags.LOGIN_TAG, "Not password")
            displayError(binding.errorPswdLogin, getString(R.string.enter_password))
            return
        }
        binding.errorPswdLogin.visibility = INVISIBLE
        loginViewModel.loginUser(email, password)
    }


    private fun displayError(textView: TextView, text: String) {
        textView.text = text
        textView.visibility = VISIBLE
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