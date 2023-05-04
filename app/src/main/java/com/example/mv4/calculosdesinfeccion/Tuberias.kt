package com.example.mv4.calculosdesinfeccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.mv4.R
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.pow

class Tuberias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuberias)
        showToolbar("Tuberias",true)

        val longitud =  findViewById<TextInputEditText>(R.id.inputLongitudTuberia)
        val diametro = findViewById<TextInputEditText>(R.id.inputDiametroTuberia)
        val calcular = findViewById<Button>(R.id.buttonCalcTuberias)
        val resultado = findViewById<TextView>(R.id.resultadoVolumenTuberia)

        calcular.setOnClickListener {
            val longitud = longitud.text.toString().toDouble()
            val diametro = diametro.text.toString().toDouble()
            val pulgada = diametro * 0.0294
            val calculo = pulgada.pow(2)/4* 3.1416 * longitud
            resultado.text = "resultado: ${calculo.toString()}"
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