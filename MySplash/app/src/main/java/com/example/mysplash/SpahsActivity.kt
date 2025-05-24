package com.example.mysplash

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpahsActivity : AppCompatActivity() {
    lateinit var txtProgrss: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spahs)

        txtProgrss = findViewById(R.id.txtProgress)

        splash()

    }

    private fun splash() {
        object  : CountDownTimer(5000,1000){
            override fun onTick(millisUntilFinished: Long) {
                txtProgrss.setText("la app iniciara en: " + millisUntilFinished/1000)
            }

            override fun onFinish() {
                var mIntent = Intent(applicationContext, MainActivity::class.java).apply{ }
                startActivity(mIntent)

            }

        }.start()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}

