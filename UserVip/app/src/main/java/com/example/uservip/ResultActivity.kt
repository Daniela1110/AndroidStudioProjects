package com.example.uservip

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.uservip.UserVipApplication.Companion.prefs

class ResultActivity : AppCompatActivity() {

    private lateinit var btnBack: Button
    private lateinit var tvName : TextView
    private lateinit var container: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)


        btnBack   = findViewById(R.id.btnBack)
        tvName    = findViewById(R.id.tvName)
        container = findViewById(R.id.container)


        iniUI()
    }
    private fun iniUI() {
        // Botón de regreso
        btnBack.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }

        val userName = prefs.getName()
        tvName.text = "Bienvenido $userName"


        if (prefs.getVIP()) {
            setVipColorBackground()
        }
    }
    private fun setVipColorBackground() {
        // Asegúrate de que R.color.vip_yellow exista
        val color = ContextCompat.getColor(this, R.color.vip_yellow)
        container.setBackgroundColor(color)
    }
}
