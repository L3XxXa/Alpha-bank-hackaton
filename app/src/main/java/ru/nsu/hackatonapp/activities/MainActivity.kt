package ru.nsu.hackatonapp.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.*
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import ru.nsu.hackatonapp.databinding.ActivityMainBinding
import ru.nsu.hackatonapp.utils.LogTags
import android.widget.Toast
import androidx.databinding.BindingAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.domain.viewmodels.LoginViewModel
import ru.nsu.hackatonapp.network.BaseResponse
import java.io.Console

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
    }

    private fun register() {
        val intent = Intent(this, RegistrationActivity::class.java)
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
                    Toast.makeText(this, "Successfully logged in", Toast.LENGTH_SHORT).show()
                    Log.i(LogTags.LOGIN_TAG, "Successfully logged in")
                }
                else -> {
                    Log.e(LogTags.LOGIN_TAG, "Unexpected error")
                }
            }
        }
    }

    private fun login() {
        val email = binding.loginEmail.text.toString()
        val password = binding.loginPassword.text.toString()
        if (!checkEmail(binding.loginEmail.text.toString())){
            if (!checkPassword(binding.loginPassword.text.toString())){
                Log.i(LogTags.LOGIN_TAG, "Not password")
                return
            }
            Log.i(LogTags.LOGIN_TAG, "Not email")
            return
        }
        binding.errorEmailLogin.visibility = INVISIBLE
        if (!checkPassword(binding.loginPassword.text.toString())){
            Log.i(LogTags.LOGIN_TAG, "Not password")
            return
        }
        binding.errorPswdLogin.visibility = INVISIBLE
        loginViewModel.loginUser(email, password)
    }

    private fun checkPassword(password: String): Boolean {
        if(password == ""){
            displayError(binding.errorPswdLogin, getString(R.string.enter_password))
            return false
        }
        return true
    }

    private fun checkEmail(email: String): Boolean {
        val regex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        if(!regex.toRegex().matches(email)){
            displayError(binding.errorEmailLogin, getString(R.string.enter_valid_email))
            return false
        }
        return true
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