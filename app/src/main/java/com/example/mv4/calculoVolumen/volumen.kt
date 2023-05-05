package com.example.mv3.calculoVolumen

class volumen {
        companion object {
            fun captacion_CamRompPres_ReservorioRectan(altura: Double, ancho: Double, largo: Double): Double {
                return altura * ancho * largo
            }
            fun mostrar_resultado_volumen(resultado: Double): Double {
                return resultado * 1000

            }
        }

}