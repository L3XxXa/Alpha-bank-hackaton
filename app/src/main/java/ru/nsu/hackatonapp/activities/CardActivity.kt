package ru.nsu.hackatonapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.hackatonapp.databinding.ActivityCardBinding

class CardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityCardBinding.inflate(layoutInflater)

    }
}