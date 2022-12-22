package ru.nsu.hackatonapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.databinding.ActivityCreateCardBinding
import ru.nsu.hackatonapp.domain.viewmodels.AddCardViewModel
import ru.nsu.hackatonapp.domain.viewmodels.LoginViewModel
import ru.nsu.hackatonapp.network.BaseResponse
import ru.nsu.hackatonapp.utils.FieldValidators
import ru.nsu.hackatonapp.utils.LogTags

class CreateCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCardBinding
    private val viewModel: AddCardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityCreateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.openCamera.setOnClickListener {
            openCamera()
        }
        binding.createCard.setOnClickListener {
            createCard()
        }
        addCardObserver()

    }

    private fun addCardObserver() {
        viewModel.result.observe(this) {
            when (it) {
                is BaseResponse.Loading -> {
                    Log.d(LogTags.ADD_CARD, "Loading")
                }
                is BaseResponse.Success -> {
                    Log.d(LogTags.ADD_CARD, "Successfully added a card")
                    Toast.makeText(this, "Карта добавлена", Toast.LENGTH_SHORT).show()
                }
                is BaseResponse.Error -> {
                    Log.e(LogTags.ADD_CARD, "Error while loading a card status code ${it.msg}")
                    Toast.makeText(this, "Ошибка при добавлении карты", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun createCard() {
        if (!FieldValidators.checkFieldNotEmpty(binding.shopName.text.toString())) {
            Toast.makeText(this, "Введите название магазина", Toast.LENGTH_SHORT).show()
            return
        }
        val sharedPrefEmail =
            getSharedPreferences(getString(R.string.pref_email_file_name), Context.MODE_PRIVATE)
        val userId = sharedPrefEmail.getString("userId", "-1")
        val sharedPrefCode =
            getSharedPreferences(getString(R.string.pref_code_file_name), Context.MODE_PRIVATE)
        val code = sharedPrefCode.getString("code", "-1")
        Log.d(LogTags.ADD_CARD, "$userId, $code")
        viewModel.addCard(userId!!, binding.shopName.text.toString(), code!!, "0")

    }

    private fun openCamera() {
        val intent = Intent(this, BarcodeScannerActivity::class.java)
        startActivity(intent)
    }

}