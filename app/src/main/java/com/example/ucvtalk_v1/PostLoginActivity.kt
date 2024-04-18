package com.example.ucvtalk_v1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ucvtalk_v1.databinding.ActivityPostLoginBinding


class PostLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btBack.setOnClickListener{onBackPressedDispatcher.onBackPressed()}
        binding.btFuncionA.setOnClickListener{temp()}
        getAndShowName()
    }

    fun getAndShowName(){
        val name = intent.getStringExtra("INTENT_NAME")
        binding.tVUsuario.text = "BIENVENIDO $name"

    }

    fun temp(){
        val intent = Intent(this,tempActivity::class.java)
        startActivity(intent)
    }
}