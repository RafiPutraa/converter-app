package com.dicoding.mynewapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.mynewapp.R
import com.dicoding.mynewapp.databinding.ActivityLengthBinding

class LengthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLengthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLengthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}