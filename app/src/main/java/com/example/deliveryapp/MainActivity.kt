package com.example.deliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.deliveryapp.burger.Burger
import com.example.deliveryapp.burger.BurgerAdapter
import com.example.deliveryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<Burger>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        loadData()
        val adapter = BurgerAdapter(list)
        binding.rvBurger.adapter = adapter
    }

    private fun loadData() {
        list.add(Burger("BNB Burger", R.drawable.burger))
        list.add(Burger("BNB Burger", R.drawable.burger))
        list.add(Burger("BNB Burger", R.drawable.burger))
        list.add(Burger("BNB Burger", R.drawable.burger))
        list.add(Burger("BNB Burger", R.drawable.burger))
        list.add(Burger("BNB Burger", R.drawable.burger))
        list.add(Burger("BNB Burger", R.drawable.burger))
        list.add(Burger("BNB Burger", R.drawable.burger))
        list.add(Burger("BNB Burger", R.drawable.burger))
    }
}