package com.example.asesmen3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Mendapatkan data yang dikirim dari MainActivity4
        val image = intent.getIntExtra("image", 0)
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")

        // Menampilkan data pada UI
        val imageView = findViewById<ImageView>(R.id.detailImage)
        val titleTextView = findViewById<TextView>(R.id.detailTitle)
        val descTextView = findViewById<TextView>(R.id.detailDesc)

        imageView.setImageResource(image)
        titleTextView.text = title
        descTextView.text = desc

        val button = findViewById<Button>(R.id.button)

        // set OnClickListener on the button
        button.setOnClickListener {
            // create an Intent to start MainActivity6 (ganti dengan nama Activity yang diinginkan)
            val intent = Intent(this, MainActivity5::class.java)

            // start the new Activity
            startActivity(intent)
        }
    }
}
