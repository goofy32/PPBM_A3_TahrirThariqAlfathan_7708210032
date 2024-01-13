package com.example.asesmen3

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val singUp = findViewById<TextView>(R.id.singUp)
        val logIn = findViewById<TextView>(R.id.logIn)
        val singUpLayout = findViewById<LinearLayout>(R.id.singUpLayout)
        val logInLayout = findViewById<LinearLayout>(R.id.logInLayout)
        val Singin = findViewById<Button>(R.id.singIn)
        val fb = findViewById<ImageView>(R.id.btn_show)
        val gg = findViewById<ImageView>(R.id.btn_show2)
        val tT = findViewById<ImageView>(R.id.btn_show3)

        val bottomSheetFragment = BottomSheetFragment()

        fb.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "bottomSheetDialog")
        }

        gg.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "bottomSheetDialog")
        }

        tT.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "bottomSheetDialog")
        }

        Singin.setOnClickListener {
            startActivity(Intent(this@MainActivity2, MainActivity::class.java))
        }

        singUp.setOnClickListener {
            singUp.background = resources.getDrawable(R.drawable.switch_trcks, null)
            singUp.setTextColor(resources.getColor(R.color.black, null))
            logIn.background = null
            singUpLayout.visibility = View.VISIBLE
            logInLayout.visibility = View.GONE
            logIn.setTextColor(resources.getColor(R.color.black, null))
        }

        logIn.setOnClickListener {
            singUp.background = null
            singUp.setTextColor(resources.getColor(R.color.black, null))
            logIn.background = resources.getDrawable(R.drawable.switch_trcks, null)
            singUpLayout.visibility = View.GONE
            logInLayout.visibility = View.VISIBLE
            logIn.setTextColor(resources.getColor(R.color.black, null))
        }
    }
}