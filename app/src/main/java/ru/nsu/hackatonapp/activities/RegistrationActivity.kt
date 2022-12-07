package ru.nsu.hackatonapp.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View.*
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.databinding.ActivityRegistrationBinding
import ru.nsu.hackatonapp.utils.FieldValidators
import ru.nsu.hackatonapp.utils.LogTags

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        Log.d(LogTags.REGISTRATION, "Starting activity $this")
        setContentView(binding.root)
        Log.d(LogTags.REGISTRATION, "Set content view")
        binding.registerButton.setOnClickListener{
            register()
        }
    }

    private fun register() {
        binding.errorEmailRegister.visibility = INVISIBLE
        binding.errorPswdRegister.visibility = INVISIBLE
        binding.errorConfirmPswdRegister.visibility = INVISIBLE
        if(!FieldValidators.checkEmail(binding.registerEmail.text.toString())){
            displayError(binding.errorEmailRegister, getString(R.string.enter_valid_email))
            Log.e(LogTags.REGISTRATION, "Not email")
            if (!FieldValidators.checkPassword(binding.registerPassword.text.toString())){
                displayError(binding.errorPswdRegister, getString(R.string.enter_password))
                Log.e(LogTags.REGISTRATION, "Not password")
                if (!FieldValidators.checkPassword(binding.registerConfirmPassword.text.toString())){
                    displayError(binding.errorConfirmPswdRegister, getString(R.string.enter_password))
                    Log.e(LogTags.REGISTRATION, "Not password 2")
                    return
                }
                return
            }
            return
        }
        if (!FieldValidators.checkPassword(binding.registerPassword.text.toString())){
            displayError(binding.errorPswdRegister, getString(R.string.enter_password))
            Log.e(LogTags.REGISTRATION, "Not password")
            if (!FieldValidators.checkPassword(binding.registerConfirmPassword.text.toString())){
                displayError(binding.errorConfirmPswdRegister, getString(R.string.enter_password))
                Log.e(LogTags.REGISTRATION, "Not password 2")
                return
            }
            return
        }
        if (!FieldValidators.checkPassword(binding.registerConfirmPassword.text.toString())){
            displayError(binding.errorConfirmPswdRegister, getString(R.string.enter_password))
            Log.e(LogTags.REGISTRATION, "Not password 2")
            return
        }
        if (!FieldValidators.checkLengthPassword(binding.registerPassword.text.toString())){
            displayError(binding.errorPswdRegister, getString(R.string.password_len))
            Log.e(LogTags.REGISTRATION, "Bad password len")
            return
        }
        if (!FieldValidators.confirmPassword(binding.registerPassword.text.toString(), binding.registerConfirmPassword.text.toString())){
            displayError(binding.errorPswdRegister, getString(R.string.not_equal_passwords))
            displayError(binding.errorConfirmPswdRegister, getString(R.string.not_equal_passwords))
            Log.e(LogTags.REGISTRATION, "Not equal passwords")
            return
        }

    }

    private fun displayError(textView: TextView, text: String) {
        textView.text = text
        textView.visibility = VISIBLE
    }

}