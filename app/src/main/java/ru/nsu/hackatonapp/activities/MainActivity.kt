package ru.nsu.hackatonapp.activities

import android.Manifest
import android.content.Context
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
import ru.nsu.hackatonapp.utils.UserID

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private var userId: String? = null
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
                    Log.i(LogTags.LOGIN_TAG, "Logging ...")
                }
                is BaseResponse.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    Log.e(LogTags.LOGIN_TAG, "Error while logging. ${it.msg}")
                }
                is BaseResponse.Success -> {
                    UserID.userID = it.data?.result!!
                    startCardsActivity(UserID.userID)
                    Log.i(LogTags.LOGIN_TAG, "Successfully logged in + ${it.data.result}")
                }
                else -> {
                    Log.e(LogTags.LOGIN_TAG, "Unexpected error")
                }
            }
        }
    }

    private fun startCardsActivity(userId: String) {
        val sharedPref = getSharedPreferences(getString(R.string.pref_email_file_name),Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("userId", userId)
        editor.apply()
        val email_s = sharedPref.getString("userId", "user")
        Log.d(LogTags.LOGIN_TAG, " user id is $email_s")
        val intent = Intent(this, CardsActivity::class.java)
        startActivity(intent)
    }

    private fun login() {
        val email = binding.loginEmail.text.toString()
        val password = binding.loginPassword.text.toString()
        if (!FieldValidators.checkEmail(email)){
            displayError(binding.errorEmailLogin, getString(R.string.enter_valid_email))
            Log.e(LogTags.LOGIN_TAG, "Not email")
            if (!FieldValidators.checkFieldNotEmpty(password)){
                Log.e(LogTags.LOGIN_TAG, "Not password")
                displayError(binding.errorPswdLogin, getString(R.string.enter_password))
                return
            }
            return
        }
        binding.errorEmailLogin.visibility = INVISIBLE
        if (!FieldValidators.checkFieldNotEmpty(password)){
            Log.e(LogTags.LOGIN_TAG, "Not password")
            displayError(binding.errorPswdLogin, getString(R.string.enter_password))
            return
        }
        binding.errorPswdLogin.visibility = INVISIBLE
        loginViewModel.loginUser(email, password)
        val sharedPref = getSharedPreferences(getString(R.string.pref_email_file_name),Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("email", email)
        editor.apply()
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

    override fun onBackPressed() {

    }
}