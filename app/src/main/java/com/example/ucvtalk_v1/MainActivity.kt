package com.example.ucvtalk_v1

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ucvtalk_v1.activities.LoginActivity
import com.example.ucvtalk_v1.data.RetrofitServiceFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = RetrofitServiceFactory.makeRetrofitService()

        lifecycleScope.launch {
            val estudiantes = service.ReadAllEstudiantes()
            println(estudiantes)
        }
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}
