package ru.nsu.hackatonapp.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View.*
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.databinding.ActivityRegistrationBinding
import ru.nsu.hackatonapp.domain.viewmodels.RegisterViewModel
import ru.nsu.hackatonapp.network.BaseResponse
import ru.nsu.hackatonapp.utils.FieldValidators
import ru.nsu.hackatonapp.utils.LogTags

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private val registerViewModel: RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        Log.d(LogTags.REGISTRATION, "Starting activity $this")
        setContentView(binding.root)
        Log.d(LogTags.REGISTRATION, "Set content view")
        registrationObserver()
        binding.registerButton.setOnClickListener{
            register()
        }
    }

    private fun registrationObserver() {
        registerViewModel.registerResult.observe(this){
            when(it){
                is BaseResponse.Loading -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                    Log.i(LogTags.REGISTRATION, "Logging...")
                }
                is BaseResponse.Error -> {
                    Toast.makeText(this, "Error while registration. ${it.msg}", Toast.LENGTH_SHORT).show()
                    Log.e(LogTags.REGISTRATION, "Error while registration. ${it.msg}")
                }
                is BaseResponse.Success -> {
                    Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
                    Log.i(LogTags.REGISTRATION, "Successful registration")
                }
                else -> {
                    Log.e(LogTags.REGISTRATION, "Unexpected error")
                }
            }
        }
    }

    private fun register() {
        binding.errorEmailRegister.visibility = INVISIBLE
        binding.errorPswdRegister.visibility = INVISIBLE
        binding.errorConfirmPswdRegister.visibility = INVISIBLE
        val email = binding.registerEmail.text.toString()
        val password1 = binding.registerPassword.text.toString()
        val password2 = binding.registerConfirmPassword.text.toString()
        if(!FieldValidators.checkEmail(email)){
            displayError(binding.errorEmailRegister, getString(R.string.enter_valid_email))
            Log.e(LogTags.REGISTRATION, "Not email")
            if (!FieldValidators.checkPassword(password1)){
                displayError(binding.errorPswdRegister, getString(R.string.enter_password))
                Log.e(LogTags.REGISTRATION, "Not password")
                if (!FieldValidators.checkPassword(password2)){
                    displayError(binding.errorConfirmPswdRegister, getString(R.string.enter_password))
                    Log.e(LogTags.REGISTRATION, "Not password 2")
                    return
                }
                return
            }
            return
        }
        if (!FieldValidators.checkPassword(password1)){
            displayError(binding.errorPswdRegister, getString(R.string.enter_password))
            Log.e(LogTags.REGISTRATION, "Not password")
            if (!FieldValidators.checkPassword(password2)){
                displayError(binding.errorConfirmPswdRegister, getString(R.string.enter_password))
                Log.e(LogTags.REGISTRATION, "Not password 2")
                return
            }
            return
        }
        if (!FieldValidators.checkLengthPassword(password1)){
            displayError(binding.errorPswdRegister, getString(R.string.password_len))
            Log.e(LogTags.REGISTRATION, "Bad password len")
            return
        }
        if (!FieldValidators.checkPassword(password2)){
            displayError(binding.errorConfirmPswdRegister, getString(R.string.enter_password))
            Log.e(LogTags.REGISTRATION, "Not password 2")
            return
        }
        if (!FieldValidators.confirmPassword(password1, password2)){
            displayError(binding.errorPswdRegister, getString(R.string.not_equal_passwords))
            displayError(binding.errorConfirmPswdRegister, getString(R.string.not_equal_passwords))
            Log.e(LogTags.REGISTRATION, "Not equal passwords")
            return
        }
        registerViewModel.registerUser(email, password1)
    }

    private fun displayError(textView: TextView, text: String) {
        textView.text = text
        textView.visibility = VISIBLE
    }
}