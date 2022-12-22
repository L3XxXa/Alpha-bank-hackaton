package ru.nsu.hackatonapp.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.databinding.ActivityRestorePasswordBinding
import ru.nsu.hackatonapp.domain.viewmodels.ChangePasswordViewModel
import ru.nsu.hackatonapp.network.BaseResponse
import ru.nsu.hackatonapp.utils.FieldValidators
import ru.nsu.hackatonapp.utils.LogTags

class RestorePasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestorePasswordBinding
    private val viewModel: ChangePasswordViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityRestorePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()
        binding.restorePasswordButton.setOnClickListener{
            restorePassword()
        }
        binding.restoreCode.setOnClickListener{
            Toast.makeText(this, "Мы сильно трудимся, чтобы добавить верификацию пароля", Toast.LENGTH_SHORT).show()
        }
    }

    private fun restorePassword() {
        if (!FieldValidators.checkLengthPassword(binding.restorePassword.text.toString())){
            Toast.makeText(this, "Длина пароля < 8, длина пароля > 16", Toast.LENGTH_SHORT).show()
            return
        }
        if (!FieldValidators.checkFieldNotEmpty(binding.restorePassword.text.toString())){
            Toast.makeText(this, "Введите пароль", Toast.LENGTH_SHORT).show()
            return
        }
        if (!FieldValidators.confirmPassword(binding.restorePassword.text.toString(), binding.restoreConfirmPassword.text.toString())){
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
            return
        }
        viewModel.changePassword(binding.restoreEmail.text.toString(), binding.restorePassword.text.toString())
    }

    private fun observer() {
        viewModel.result.observe(this){
            when(it){
                is BaseResponse.Loading->{
                    Toast.makeText(this, getString(R.string.loading), Toast.LENGTH_SHORT).show()
                    Log.d(LogTags.RESTORE_PSWD, "restoring password")
                }
                is BaseResponse.Error -> {
                    Toast.makeText(this, "Ошибка во время смены пароля. ${it.msg}", Toast.LENGTH_SHORT).show()
                    Log.e(LogTags.RESTORE_PSWD, "Error while changing password")
                }
                is BaseResponse.Success -> {
                    Toast.makeText(this, "Успешная смена пароля", Toast.LENGTH_SHORT).show()
                    Log.d(LogTags.RESTORE_PSWD, "Successfully changed the password")
                }
                else -> {
                    Log.e(LogTags.RESTORE_PSWD, "Unexpected error")
                }
            }
        }

    }
}