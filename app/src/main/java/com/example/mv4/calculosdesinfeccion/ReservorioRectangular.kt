package com.example.mv4.calculosdesinfeccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.mv4.R
import com.example.mv3.calculoVolumen.volumen
import com.google.android.material.textfield.TextInputEditText
import ocultarTecladoUI

class ReservorioRectangular : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservorio_rectangular)
        showToolbar("Reservorio Rectángular", true)

        val altura = findViewById<TextInputEditText>(R.id.inputAlturaReserRec)
        val ancho = findViewById<TextInputEditText>(R.id.inputAnchoReserRec)
        val largo =  findViewById<TextInputEditText>(R.id.inputLargoReserRect)
        val resultado = findViewById<TextView>(R.id.resultadoVoloumenReserRectan)
        val buttoncalc = findViewById<Button>(R.id.buttonCalcReserRectan)



        buttoncalc.setOnClickListener {
            val altura = altura.text.toString().toDouble()
            val ancho = ancho.text.toString().toDouble()
            val largo = largo.text.toString().toDouble()
            val calculo = volumen.calcularVolumen(altura,ancho,largo)
            resultado.text = "Resultado: ${calculo.toString()}"
            ocultarTecladoUI.ocultarTeclado(this)
            mostrarLinear()
        }
    }

    fun mostrarLinear(){
        val myLinearLayout = findViewById<LinearLayout>(R.id.linearResultado)
        if (myLinearLayout.visibility == View.GONE) {
            myLinearLayout.visibility = View.VISIBLE
        } else {
            myLinearLayout.visibility = View.GONE
        }
    }
    fun showToolbar(title: String, upButton: Boolean) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTitleText)
    }


}