package ru.nsu.hackatonapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.adapters.CardGridAdapter
import ru.nsu.hackatonapp.databinding.ActivityCardsBinding
import ru.nsu.hackatonapp.domain.viewmodels.CardsViewModel
import ru.nsu.hackatonapp.network.Api
import ru.nsu.hackatonapp.utils.LogTags

class CardsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardsBinding
    private val viewModel: CardsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        placeEmail()
        requestCards()
        binding.createCard.setOnClickListener {
            createCardActivity()
        }
        binding.logout.setOnClickListener {
            logout()
        }

        binding.refreshCards.setOnClickListener {
            requestCards()
        }
    }

    private fun requestCards() {
        val sharedPrefEmail =
            getSharedPreferences(getString(R.string.pref_email_file_name), Context.MODE_PRIVATE)
        val userId = sharedPrefEmail.getString("userId", "-1")
        Log.d(LogTags.ACTIVITY_CARD, userId!!)
        binding.cardsGrid.adapter = CardGridAdapter()

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