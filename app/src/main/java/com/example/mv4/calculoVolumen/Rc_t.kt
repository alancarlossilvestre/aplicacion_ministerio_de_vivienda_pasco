package com.example.mv4.calculoVolumen

import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.pow

class rc_t {

        companion object {
            fun nombre_toolbar(title: String, longitudin: TextInputEditText, diametroin: TextInputEditText,
                               resultado: TextView, ) {
                when (title) {
                    "Tuberías" -> {
                        val longitud = longitudin.text.toString().toDouble()
                        val diametro = diametroin.text.toString().toDouble()
                        val pulgada = diametro * 0.0294
                        val calculo = pulgada.pow(2)/4* 3.1416 * longitud
                        resultado.text = "resultado: ${calculo.toString()}"
                                            }
                    "Reservorio Circular" -> {
                        val altura = longitudin.text.toString().toDouble()
                        val diametro = diametroin.text.toString().toDouble()
                        val calculo = diametro.toDouble().pow(2)  / 4 * 3.1416 * altura
                        resultado.text = "Resultado: ${calculo.toString()}"
                    }
                }
            }
        }
    }
