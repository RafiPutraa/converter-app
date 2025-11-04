package com.dicoding.mynewapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.mynewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnButton.setOnClickListener {
            goToMenu()
        }
        binding.tvClickHere.setOnClickListener {
            goToRegister()
        }
    }

    private fun goToMenu() {
        val un = binding.etLoginUsername.text.toString()
        val pw = binding.etLoginPassword.text.toString()

        when {
            un.isNotEmpty() && pw.isNotEmpty() -> {
                startActivity(Intent(this, MenuActivity::class.java))
                finishAffinity()
            }
            else -> {
                Toast.makeText(this, "Please fill the empty field!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goToRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}


