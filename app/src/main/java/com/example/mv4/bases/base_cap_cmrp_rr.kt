package com.example.mv4.bases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.mv4.R
import com.example.mv3.calculoVolumen.volumen.Companion.captacion_CamRompPres_ReservorioRectan
import com.example.mv3.calculoVolumen.volumen.Companion.mostrar_resultado_volumen
import com.google.android.material.textfield.TextInputEditText


class base_cap_cmrp_rr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_cap_cmrp_rr)

        // Obtener el título del toolbar del intent
        val toolbarTitle = intent.getStringExtra("titulo_toolbar")

        // Establecer el título del toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = toolbarTitle

        val alturain = findViewById<TextInputEditText>(R.id.inputAlturaReserRec)
        val anchoin = findViewById<TextInputEditText>(R.id.inputAnchoReserRec)
        val largoin =  findViewById<TextInputEditText>(R.id.inputLargoReserRect)
        val resultado = findViewById<TextView>(R.id.resultadoVoloumenReserRectan)
        val resultadoLitro = findViewById<TextView>(R.id.resultadoPesoLitro)
        val buttoncalc = findViewById<Button>(R.id.buttonCalcReserRectan)

        buttoncalc.setOnClickListener {
            if (alturain.text.isNullOrEmpty() || anchoin.text.isNullOrEmpty() || largoin.text.isNullOrEmpty()) {
                Toast.makeText(this, "Tiene que rellenar todos los datos", Toast.LENGTH_SHORT)
                    .show()
            }

            //calculo del resultado
            else {
                val altura = alturain.text.toString().toDouble()
                val ancho = anchoin.text.toString().toDouble()
                val largo = largoin.text.toString().toDouble()
                val calculo = captacion_CamRompPres_ReservorioRectan(altura, ancho, largo)
                resultado.text = "Resultado: ${calculo.toString()}"
                val l = mostrar_resultado_volumen(calculo)
                resultadoLitro.text = "${l.toString()} Litros"
                ocultarTecladoUI.ocultarTeclado(this)
                mostrarLinear()

            }
        }

    }
    private var linearLayoutVisible = true
    fun mostrarLinear(){
        val myLinearLayout = findViewById<LinearLayout>(R.id.linearResultado)
        if (linearLayoutVisible) { // comprobar si el layout está visible
            myLinearLayout.visibility = View.VISIBLE
            linearLayoutVisible = true // cambiar el estado del layout a invisible
        } else {
            myLinearLayout.visibility = View.GONE
        }
      }
}