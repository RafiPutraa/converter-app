package com.dicoding.mynewapp.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.mynewapp.R
import com.dicoding.mynewapp.databinding.ActivityTemperatureBinding
import java.text.DecimalFormat

class TemperatureActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemperatureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemperatureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tempScale = arrayOf("°C", "°F", "°R", "K")
        val arrayAdp = ArrayAdapter(this@TemperatureActivity, android.R.layout.simple_spinner_dropdown_item, tempScale)
        binding.ddTemp.adapter = arrayAdp

        binding.btnConvert.setOnClickListener { calculate() }
    }

    private fun calculate(){
        val textValue = binding.etTemp.text.toString()
        val value = textValue.toDouble()
        val selectedUnit = binding.ddTemp.selectedItem.toString()
        val df = DecimalFormat("#.##")

        if (textValue.isEmpty()){
            Toast.makeText(this,"Please insert the temperature", Toast.LENGTH_SHORT).show()
        }

        when (selectedUnit) {
            "°C" -> {
                val fah = ((value * 9) / 5) + 32
                val rea = (value * 4) / 5
                val kel = value + 273

                binding.celValue.text = textValue
                binding.fahValue.text = df.format(fah).toString()
                binding.reaValue.text = df.format(rea).toString()
                binding.kelValue.text = df.format(kel).toString()
            }
            "°F" -> {
                val cel = ((value - 32) * 5 ) / 9
                val rea = ((value - 32) * 4 ) / 9
                val kel = (((value - 32) * 5) / 9) + 273

                binding.celValue.text = df.format(cel).toString()
                binding.fahValue.text = textValue
                binding.reaValue.text = df.format(rea).toString()
                binding.kelValue.text = df.format(kel).toString()
            }
            "°R" -> {
                val cel = ((value * 5)/4)
                val fah = ((value * 9)/4) + 32
                val kel = ((value * 5)/4) + 273

                binding.celValue.text = df.format(cel).toString()
                binding.fahValue.text = df.format(fah).toString()
                binding.reaValue.text = textValue
                binding.kelValue.text = df.format(kel).toString()
            }
            else -> {
                val cel = value - 273
                val fah = (((value - 273) * 9)/5) + 32
                val rea = (((value - 273) * 4)/5)

                binding.celValue.text = df.format(cel).toString()
                binding.fahValue.text = df.format(fah).toString()
                binding.reaValue.text = df.format(rea).toString()
                binding.kelValue.text = textValue
            }
        }
    }
}