package com.example.myjob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    var campoNombre: EditText?=null
    var campoApellido: EditText?=null
    var campoEdad: EditText?=null
    var campoTelefono: EditText?=null
    var campoProducto: EditText?=null
    var campoCant: EditText?=null
    var campoPrice: EditText?=null
    var desc : Double = 0.0
    var Tipo: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNombre = findViewById(R.id.NameUser)
        campoApellido = findViewById(R.id.apellido)
        campoEdad = findViewById(R.id.AgeUser)
        campoTelefono = findViewById(R.id.Cellnumber)
        campoProducto = findViewById(R.id.NameProduct)
        campoCant = findViewById(R.id.CantProduct)
        campoPrice = findViewById(R.id.PriceProduct)


        val miBtn1: Button = findViewById(R.id.BtnCalculate)
        miBtn1.setOnClickListener { onClick(1) }

        val miBtn2: Button = findViewById(R.id.BtnShow)
        miBtn2.setOnClickListener { onClick(2) }

        val miBtn3: Button = findViewById(R.id.BtnClean)
        miBtn3.setOnClickListener { onClick(3) }

    }

    private fun onClick(boton: Int) {
        when(boton){
            1->{
                var valorU: Double= campoPrice?.text.toString().toDouble()
                var cantProduct: Double= campoCant?.text.toString().toDouble()
                var totalDesc: Double = 0.0
                var total = valorU * cantProduct


                getRadioButton()

                totalDesc = total - (total * desc)


                val intent = Intent(this,NewWindow::class.java)
                val miBundleNom:Bundle=Bundle()
                miBundleNom.putString("Nombre",campoNombre!!.text.toString())
                intent.putExtras(miBundleNom)

                val miBundleTipo:Bundle=Bundle()
                miBundleTipo.putString("Tipo",Tipo)
                intent.putExtras(miBundleTipo)

                val bundleTotal:Bundle=Bundle()
                bundleTotal.putString("Descuento",totalDesc.toString())
                intent.putExtras(bundleTotal)

                val bundleTotalReal:Bundle=Bundle()
                bundleTotalReal.putString("PrecioReal",total.toString())
                intent.putExtras(bundleTotalReal)

                startActivity(intent)
            }
            2->{
                if(campoNombre?.text.toString().isEmpty() || campoApellido?.text.toString().isEmpty() || campoEdad?.text.toString().isEmpty() || campoTelefono?.text.toString().isEmpty()){
                    Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
                    return
                }else{
                    getRadioButton()

                    val intent = Intent(this,DatosUser::class.java)
                    val miBundleNom:Bundle=Bundle()
                    miBundleNom.putString("Nombre",campoNombre!!.text.toString())
                    intent.putExtras(miBundleNom)

                    val miBundleAp:Bundle=Bundle()
                    miBundleAp.putString("Apellido",campoApellido!!.text.toString())
                    intent.putExtras(miBundleAp)

                    val miBundleEdad:Bundle=Bundle()
                    miBundleEdad.putString("Edad",campoEdad!!.text.toString())
                    intent.putExtras(miBundleEdad)

                    val miBundleTel:Bundle=Bundle()
                    miBundleTel.putString("Telefono",campoTelefono!!.text.toString())
                    intent.putExtras(miBundleTel)

                    val miBundleTipo:Bundle=Bundle()
                    miBundleTipo.putString("Tipo",Tipo)
                    intent.putExtras(miBundleTipo)

                    startActivity(intent)}

            }
            3-> {
                var r1: RadioButton = findViewById(R.id.TipoA)
                var r2: RadioButton = findViewById(R.id.TipoB)
                var r3: RadioButton = findViewById(R.id.TipoC)

                if (r1.isChecked) {
                    r1.isChecked = false
                } else if (r2.isChecked) {
                    r2.isChecked = false
                } else if (r3.isChecked) {
                    r3.isChecked = false
                }

                campoNombre?.setText("")
                campoApellido?.setText("")
                campoEdad?.setText("")
                campoTelefono?.setText("")
                campoProducto?.setText("")
                campoPrice?.setText("")
                campoCant?.setText("")
            }
        }

    }

    private fun getRadioButton() {
        val radioGroup: RadioGroup = findViewById(R.id.Tipo)
        var selectId = radioGroup.checkedRadioButtonId

        when (selectId) {
            R.id.TipoA -> {
                desc = 0.4
                Tipo = "A"

            }
            R.id.TipoB -> {
                desc = 0.2
                Tipo = "B"

            }
            R.id.TipoB -> {
                desc = 0.1
                Tipo = "C"

            }else -> {
            desc = 0.0
            Tipo = "No seleccionado"

         }
        }
    }

}