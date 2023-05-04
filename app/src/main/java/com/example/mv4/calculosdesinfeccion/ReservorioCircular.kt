package com.example.mv4.calculosdesinfeccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.mv4.R
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.pow

class ReservorioCircular : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservorio_circular)
        showToolbar("Reservorio Cirular", true)

        val altura = findViewById<TextInputEditText>(R.id.inputAlturaReserCirc)
        val diametro = findViewById<TextInputEditText>(R.id.inputDiametroReserCir)
        val resultado = findViewById<TextView>(R.id.resultadoVoloumenReservorioCircular)
        val buttoncalc = findViewById<Button>(R.id.buttonCalcReserCirc)

        buttoncalc.setOnClickListener {
            val altura = altura.text.toString().toDouble()
            val diametro = diametro.text.toString().toDouble()
            val calculo = diametro.toDouble().pow(2)  / 4 * 3.1416 * altura
            resultado.text = "Resultado: ${calculo.toString()}"
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