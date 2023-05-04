package com.example.mv4

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mv4.calculosdesinfeccion.CamaraRompePresion
import com.example.mv4.calculosdesinfeccion.Captacion
import com.example.mv4.calculosdesinfeccion.ReservorioCircular
import com.example.mv4.calculosdesinfeccion.ReservorioRectangular
import com.example.mv4.calculosdesinfeccion.Tuberias

class desinfeccion : Fragment() {

    var botonCapt:Button?=null
    var botonCamRomPre:Button?=null
    var botonReserCirc:Button?=null
    var botonReserRect:Button?=null
    var botonTuberias:Button?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_desinfeccion, container, false)
        // encontrar la referencia del botón dentro de la vista inflada del fragment

        botonCapt=vista.findViewById(R.id.btnllamarCaptacion)
        botonCapt?.setOnClickListener {  val intent = Intent(vista.context, Captacion::class.java)
        startActivity(intent)
        }

        botonCamRomPre = vista.findViewById(R.id.btnllamarCamRomPre)
        botonCamRomPre?.setOnClickListener { val intent = Intent(vista.context, CamaraRompePresion::class.java)
        startActivity(intent)
        }
        botonReserCirc = vista.findViewById(R.id.btnllamarReserCircu)
        botonReserCirc?.setOnClickListener { val intent = Intent(vista.context, ReservorioCircular::class.java)
            startActivity(intent)
        }

        botonReserRect = vista.findViewById(R.id.btnllamarReserRectan)
        botonReserRect?.setOnClickListener { val intent = Intent(vista.context, ReservorioRectangular::class.java)
            startActivity(intent)
        }

        botonTuberias = vista.findViewById(R.id.btnllamarTuberias)
        botonTuberias?.setOnClickListener { val intent = Intent(vista.context, Tuberias::class.java)
            startActivity(intent)
        }

        return vista

    }

}