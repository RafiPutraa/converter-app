package com.dicoding.mynewapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.mynewapp.R
import com.dicoding.mynewapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegisterBack.setOnClickListener {
            goBack()
        }

        binding.btnRegisterConf.setOnClickListener {
            confirmReg()
        }
    }

    private fun goBack() {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }

    private fun confirmReg() {
        val un = binding.etRegisterUsername.text.toString()
        val pw = binding.etRegisterPassword.text.toString()
        val confPw = binding.etRegisterConfPassword.text.toString()

        if (un.isEmpty() && pw.isEmpty() && confPw.isEmpty()) {
            Toast.makeText(this,"Please fill the empty field!", Toast.LENGTH_SHORT).show()
        } else {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
    }
}
