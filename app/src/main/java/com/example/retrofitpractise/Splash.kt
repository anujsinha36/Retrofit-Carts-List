package com.example.retrofitpractise

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.splash)

        Handler().postDelayed(kotlinx.coroutines.Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }, 3000)

    }
}