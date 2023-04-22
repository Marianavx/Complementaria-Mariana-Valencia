package com.example.myjob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DatosUser: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Intent.FLAG_ACTIVITY_CLEAR_TOP
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datauser)

        val nombre=findViewById<TextView>(R.id.nameUser)
        val apellido=findViewById<TextView>(R.id.lastname)
        val edad=findViewById<TextView>(R.id.age)
        val telefono=findViewById<TextView>(R.id.number)
        val tipo = findViewById<TextView>(R.id.type)

        var miBundleNom: Bundle?=this.intent.extras
        var miBundleApe: Bundle?=this.intent.extras
        var miBundleEdad: Bundle?=this.intent.extras
        var miBundleTel: Bundle?=this.intent.extras
        var miBundleTipo: Bundle?=this.intent.extras

        if (miBundleNom != null){
            nombre.text="${miBundleNom.getString("Nombre")} "
            if (miBundleApe != null){
                apellido.text="${miBundleApe.getString("Apellido")}"
                if (miBundleEdad != null){
                    edad.text="${miBundleEdad.getString("Edad")}"
                    if (miBundleTel != null){
                        telefono.text="${miBundleTel.getString("Telefono")}"
                        if (miBundleTipo != null){
                            tipo.text="${miBundleTipo.getString("Tipo")}"
                        }
                    }
                }
            }
        }

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener { onclick() }

    }

    private fun onclick(){
        finish()
    }
}