package com.dicoding.mynewapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.mynewapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnLogOut.setOnClickListener { logOut() }
            binding.btnCurrency.setOnClickListener { start<CurrencyActivity>() }
            binding.btnTemp.setOnClickListener { start<TemperatureActivity>() }
            binding.btnLength.setOnClickListener { start<LengthActivity>() }
            binding.btnWeight.setOnClickListener { start<WeightActivity>() }
        }
    }

    private inline fun <reified T : ComponentActivity> start() {
        startActivity(Intent(this, T::class.java))
    }

    private fun logOut(){
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }
}