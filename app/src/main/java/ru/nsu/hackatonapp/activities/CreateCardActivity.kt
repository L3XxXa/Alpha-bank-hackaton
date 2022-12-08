package ru.nsu.hackatonapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.nsu.hackatonapp.databinding.ActivityCreateCardBinding

class CreateCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityCreateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.openCamera.setOnClickListener{
            Toast.makeText(this, "Opening camera", Toast.LENGTH_SHORT).show()
        }
    }
}