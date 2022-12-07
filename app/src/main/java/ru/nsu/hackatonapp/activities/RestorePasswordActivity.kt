package ru.nsu.hackatonapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.hackatonapp.databinding.ActivityRestorePasswordBinding

class RestorePasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestorePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        binding = ActivityRestorePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        binding.restorePasswordButton.setOnClickListener{
            restorePassword()
        }
    }

    private fun restorePassword() {

    }
}