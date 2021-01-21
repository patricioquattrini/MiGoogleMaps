package com.example.migooglempas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener { checkValue() }
    }
    fun checkValue(){
        if (ubi1.text.isNotEmpty()){
            val intent = Intent(this,MapsActivity1::class.java)
            intent.putExtra("INTENT_UBI",ubi1.text)
            startActivity(intent)
        }else {
            errorUbiVacia()
        }

    }

    fun errorUbiVacia(){
        Toast.makeText(this,"Ingrese una ubicación para continuar", Toast.LENGTH_SHORT).show()
    }
}