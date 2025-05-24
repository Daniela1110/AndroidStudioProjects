package com.example.uservip

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.uservip.UserVipApplication.Companion.prefs

class MainActivity: AppCompatActivity() {

    private lateinit var btnContinue: Button
    private lateinit var etName: EditText
    private lateinit var cbVip: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnContinue = findViewById(R.id.btnContinue)
        etName      = findViewById(R.id.etName)
        cbVip       = findViewById(R.id.cbVip)

        initUI()
        checkUserValues()
    }

    private fun checkUserValues() {
        if(prefs.getName().isNotEmpty()){
            goToDetail()
        }

    }

    fun initUI(){
        btnContinue.setOnClickListener { accessToDetail() }
    }

    fun accessToDetail() {
        if(etName.text.toString().isNotEmpty()){
            prefs.saveName(etName.text.toString())
            prefs.saveVIP(cbVip.isChecked)
            goToDetail()
        }else{

        }

    }
    fun goToDetail(){
        startActivity(Intent( this, ResultActivity::class.java))
    }
}
