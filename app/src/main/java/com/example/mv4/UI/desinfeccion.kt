package com.example.mv4.UI

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import com.example.mv4.R
import com.example.mv4.bases.base_cap_cmrp_rr
import com.example.mv4.bases.base_t_rc

class desinfeccion : Fragment() {

    var botonCapt: CardView? = null
    var botonCamRomPre: CardView? = null
    var botonReserCirc: CardView? = null
    var botonReserRect: CardView? = null
    var botonTuberias: CardView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_desinfeccion, container, false)
        // encontrar la referencia del botón dentro de la vista inflada del fragment

        botonCapt = vista.findViewById(R.id.btnllamarCaptacion)
        botonCamRomPre = vista.findViewById(R.id.btnllamarCamRomPre)
        botonReserCirc = vista.findViewById(R.id.btnllamarReserCircu)
        botonReserRect = vista.findViewById(R.id.btnllamarReserRectan)
        botonTuberias = vista.findViewById(R.id.btnllamarTuberias)


        botonCapt?.setOnClickListener {
            val intent = Intent(vista.context, base_cap_cmrp_rr::class.java)
            intent.putExtra("titulo_toolbar", "Captación")
            startActivity(intent)

        }
        botonCamRomPre?.setOnClickListener {
            val intent = Intent(vista.context, base_cap_cmrp_rr::class.java)
            intent.putExtra("titulo_toolbar", "Cámara Rompe Presión")
            startActivity(intent)

        }
        botonReserRect?.setOnClickListener {
            val intent = Intent(vista.context, base_cap_cmrp_rr::class.java)
            intent.putExtra("titulo_toolbar", "Reservorio Rectángular")
            startActivity(intent)
        }

        botonReserCirc?.setOnClickListener {
            val intent = Intent(vista.context, base_t_rc::class.java)
            intent.putExtra("titulo_toolbar", "Reservorio Circular")
            startActivity(intent)
        }

        botonTuberias?.setOnClickListener {
            val intent = Intent(vista.context,base_t_rc::class.java)
            intent.putExtra("titulo_toolbar", "Tuberías")
            startActivity(intent)
        }

        return vista

    }

}