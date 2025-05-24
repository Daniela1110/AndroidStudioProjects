package com.example.ejemplo2viewbinding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo2viewbinding.databinding.ActivityDatailBinding


class DatailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDatailBinding.inflate(layoutInflater).apply {
            setContentView(root)

            val titulostr =intent.getStringExtra("TITULO")
            val descripcionstr =intent.getStringExtra("DESCRIPCION")


            titulo.text =titulostr
            descripcion.text =descripcionstr
        }


        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun  cerar(view: View){
        finish()
    }

}