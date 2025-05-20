package com.example.crudadmin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crudadmin.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.uploadName.text.toString()
            val operator = binding.uploadOperator.text.toString()
            val location = binding.uploadLocation.text.toString()
            val phone = binding.uploadPhone.text.toString()


        databaseReference = FirebaseDatabase.getInstance().getReference("Phone Directory")
            val users = UserData(name, operator, location, phone)
        databaseReference.child(phone).setValue(users).addOnSuccessListener {
            binding.uploadName.text.clear()
            binding.uploadOperator.text.clear()
            binding.uploadLocation.text.clear()
            binding.uploadPhone.text.clear()


            Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@UploadActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }.addOnFailureListener {

            Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
        }
        }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


    }
}
}