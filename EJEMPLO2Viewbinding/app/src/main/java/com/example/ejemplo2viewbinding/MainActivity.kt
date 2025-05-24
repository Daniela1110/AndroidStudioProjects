package com.example.ejemplo2viewbinding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo2viewbinding.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            textoHolaMundo.text ="Menu Principal"
        }



        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

        fun  cambiarRapidoyFuriosos(view: View){
            val intent = Intent(this, DatailActivity::class.java).apply {
                putExtra("TITULO","Rapidos y Furiosos")
                putExtra("DESCRIPCION","Rapidos y Furiosos es una franquicia de cine estadounidense de acción que se centra en las carreras callejeras, atracos, espías y familia.")
            }
            startActivity(intent)
        }
        fun  cambiarTerminator(view: View){
        val intent = Intent(this, DatailActivity::class.java).apply {
            putExtra("TITULO","Terminator")
            putExtra("DESCRIPCION","La película \"Terminator\" de 1984 cuenta la historia de un cyborg, un Terminator, enviado desde el futuro postapocalíptico para asesinar a Sarah Connor, cuya madre es la que dará a luz al futuro líder de la resistencia humana contra las máquinas. ")
        }
        startActivity(intent)
    }

        }
