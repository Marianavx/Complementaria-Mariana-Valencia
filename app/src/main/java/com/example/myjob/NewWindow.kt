package com.example.myjob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewWindow:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Intent.FLAG_ACTIVITY_CLEAR_TOP
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newwindow)

        val nombre=findViewById<TextView>(R.id.Nombre)
        val tipo=findViewById<TextView>(R.id.Tipo)
        val precioCompraDescuento=findViewById<TextView>(R.id.compraDesc)
        val precioCompraReal=findViewById<TextView>(R.id.PrecioCompraTotal)

        var miBundleNom: Bundle?=this.intent.extras
        var miBundleTipo: Bundle?=this.intent.extras
        var bundleTotal: Bundle?=this.intent.extras
        var bundleTotalReal: Bundle?=this.intent.extras

        if (miBundleNom != null){
            nombre.text="Nombre: ${miBundleNom.getString("Nombre")} "
            if (miBundleTipo != null){
                tipo.text="Tipo: ${miBundleTipo.getString("Tipo")}"
                if (bundleTotal != null){
                    precioCompraDescuento.text="Descuento: ${bundleTotal.getString("Descuento")}"
                    if (bundleTotalReal != null){
                        precioCompraReal.text="Precio real: ${bundleTotalReal.getString("PrecioReal")}"
                    }
                }

            }
        }

        val botonSalir: Button = findViewById(R.id.btnSalir)
        botonSalir.setOnClickListener { onclick() }
    }
    private fun onclick(){
        finish()
    }
}