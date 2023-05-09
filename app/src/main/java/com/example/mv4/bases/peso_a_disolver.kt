package com.example.mv4.bases

class peso_a_disolver {

        private var resultadoVolCloro: Double = 0.0
        private var  resultadoVolCloroKilogramos: Double =0.0
        fun calcularPesoCloro(volumenCap: Double, tituloToolbar: String) {
            when (tituloToolbar) {
                "Captación","Tuberías" -> resultadoVolCloro = (volumenCap * 150) / (70 * 10)
                "Cámara Rompe Presión" -> resultadoVolCloro = (volumenCap * 7) / (70 * 10)
                "Reservorio Circular", "Reservorio Rectángular" -> resultadoVolCloro = (volumenCap *50) / (70*10)
            }
        }

        fun getResultado(): Double {
            return resultadoVolCloro
        }
}