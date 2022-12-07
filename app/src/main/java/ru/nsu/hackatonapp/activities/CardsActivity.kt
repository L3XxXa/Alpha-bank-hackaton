package ru.nsu.hackatonapp.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.hackatonapp.databinding.ActivityCardsBinding

class CardsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}