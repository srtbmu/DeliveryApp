package com.example.deliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.WindowDecorActionBar
import com.example.deliveryapp.databinding.ActivityDetailsBinding
import com.example.deliveryapp.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentActivity()
    }

    private fun getIntentActivity() {
        val header = intent.getStringExtra("name")
        val timer = intent.getStringExtra("timer")
        val image = intent.getIntExtra("image",0)
        binding.TextViewBurgerCrazeDetailes.text = header
        binding.tvTimerDetailes.text = timer
        binding.ImageViewBurgerDetailes.setImageResource(image)
    }

}