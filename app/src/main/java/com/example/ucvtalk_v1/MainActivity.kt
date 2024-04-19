package com.example.ucvtalk_v1

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.Intent
import android.os.UserHandle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ucvtalk_v1.activities.LoginActivity
import java.sql.PreparedStatement
import java.sql.SQLException

lateinit var Nombre: EditText
lateinit var Contra: EditText
lateinit var Boton: Button
class MainActivity : AppCompatActivity() {
    private var connectSql = ConnectSql()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)

        Nombre = findViewById(R.id.etUser)
        Contra = findViewById(R.id.etPassword)
        Boton= findViewById(R.id.btLogin)

        Boton.setOnClickListener {
            try {
                val conn = connectSql.dbConn() // Obtiene la conexión a la base de datos

                // Preparar la consulta SELECT
                val query = "SELECT * FROM Usuario_Registrado WHERE Usuario=? AND Contra=?"
                val preparedStatement = conn?.prepareStatement(query)
                preparedStatement?.setString(1, Nombre.text.toString())
                preparedStatement?.setString(2, Contra.text.toString())

                // Ejecutar la consulta SELECT y obtener los resultados
                val resultSet = preparedStatement?.executeQuery()

                // Verificar si la consulta devuelve filas
                if (resultSet?.next() == true) {
                    // El usuario está registrado y los datos son correctos
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show()
                } else {
                    // El usuario no está registrado o los datos son incorrectos
                    Toast.makeText(this, "Usuario no registrado o datos incorrectos", Toast.LENGTH_SHORT).show()
                }

                // Cerrar recursos
                resultSet?.close()
                preparedStatement?.close()
                conn?.close()

            } catch (ex: SQLException) {
                // Manejar errores de SQL
                ex.printStackTrace()
                Toast.makeText(this, "Error al ingresar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
