package com.example.asesmen3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val signInButton = findViewById<Button>(R.id.singIn)

        signInButton.setOnClickListener {
            // Membuat Intent untuk memulai MainActivity3
            val intent = Intent(this, MainActivity3::class.java)

            // Memulai activity baru
            startActivity(intent)
        }
    }
}