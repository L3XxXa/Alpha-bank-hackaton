package ru.nsu.hackatonapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.databinding.ActivityCardsBinding

class CardsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        placeEmail()
        binding.createCard.setOnClickListener {
            createCardActivity()
        }
        binding.logout.setOnClickListener {
            logout()
        }
    }

    private fun placeEmail() {
        val sharedPref = getSharedPreferences(getString(R.string.pref_email_file_name), Context.MODE_PRIVATE)
        val email = sharedPref.getString("email", "user")
        binding.userEmail.text = email
    }

    private fun logout() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun createCardActivity() {
        val intent = Intent(this, CreateCardActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
    }
}