package com.example.mv4.calculoVolumen

import android.widget.TextView
import com.example.mv4.bases.peso_a_disolver
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.pow

class rc_t {

        companion object {
            fun nombre_toolbar(title: String, longitudin: TextInputEditText, diametroin: TextInputEditText,
                               resultado: TextView, mostrarResultadoPesoCloro: TextView ) {
                when (title) {
                    "Tuberías" -> {
                        val longitud = longitudin.text.toString().toDouble()
                        val diametro = diametroin.text.toString().toDouble()
                        val pulgada = diametro * 0.0271
                        val calculo = pulgada.pow(2)/4* 3.1416 * longitud

                        val litros = calculo*1000
                        resultado.text = "Volumen de ${title}\n\n%.2f m3\n%.2f Litros".format(calculo, litros)
                        //resultado.text = "Volumen de ${title}\n\n${calculo.toString()} m3 \n${litros} Litros"

                        //calcular el resultado de peso de cloro a disolver

                        val calculoPesoCloro = peso_a_disolver()
                        calculoPesoCloro.calcularPesoCloro(calculo, title)
                        val resultadoPesoCloro = calculoPesoCloro.getResultado()
                        val mostrarPesoCloroGramos = resultadoPesoCloro*1000
                        mostrarResultadoPesoCloro.text = "Pedo de Cloro a Disolver\n\n%.2f Gramos\n%.2f Kilogramos".format(mostrarPesoCloroGramos, resultadoPesoCloro)

                        //mostrarResultadoPesoCloro.text = "Pedo de Cloro a Disolver\n\n${mostrarPesoCloroGramos.toString()} Gramos \n${resultadoPesoCloro.toString()} Kilogramos"

                    }
                    "Reservorio Circular" -> {
                        val altura = longitudin.text.toString().toDouble()
                        val diametro = diametroin.text.toString().toDouble()
                        val calculo = diametro.toDouble().pow(2)  / 4 * 3.1416 * altura

                        val litros = calculo*1000
                        resultado.text = "Volumen de ${title}\n\n%.2f m3\n%.2f Litros".format(calculo, litros)
                        //resultado.text = "Volumen de ${title}\n\n${calculo.toString()} m3 \n${litros} Litros"

                        //calcular el resultado de peso de cloro a disolver
                        val calculoPesoCloro = peso_a_disolver()
                        calculoPesoCloro.calcularPesoCloro(calculo, title)
                        val resultadoPesoCloro = calculoPesoCloro.getResultado()
                        val mostrarPesoCloroGramos = resultadoPesoCloro*1000
                        mostrarResultadoPesoCloro.text = "Pedo de Cloro a Disolver\n\n%.2f Gramos\n%.2f Kilogramos".format(mostrarPesoCloroGramos, resultadoPesoCloro)
                        //mostrarResultadoPesoCloro.text = "Pedo de Cloro a Disolver\n\n${mostrarPesoCloroGramos.toString()} Gramos \n${resultadoPesoCloro.toString()} Kilogramos"
                    }
                }
            }
        }
    }
