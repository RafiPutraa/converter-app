package com.dicoding.mynewapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.mynewapp.databinding.ActivityCurrencyBinding

class CurrencyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCurrencyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}