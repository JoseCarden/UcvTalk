package com.example.ucvtalk_v1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ucvtalk_v1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btLogin.setOnClickListener{checkValue()}
    }

    fun checkValue(){
        if(binding.etUser.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()){
            //Indicar a la pantalla a la que se quiere dirigir
            val intent = Intent(this,PostLoginActivity::class.java)

            //Obtener valor del EditText
            val usern = binding.etUser.text.toString()

            //Preparación de traspaso de datos
            intent.putExtra("INTENT_NAME",usern)

            //Traspaso de datos
            startActivity(intent)
        }else{
            //Mostramos diálogo
            showErrorName()
        }
    }

    fun showErrorName(){
        Toast.makeText(this, "No se completo 1 o 2 campos", Toast.LENGTH_SHORT).show()
    }
}