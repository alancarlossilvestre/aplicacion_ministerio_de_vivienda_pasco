package com.example.mv4.UI

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mv4.calculo_caudalActivity
import com.example.mv4.R


class cloracion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //llamar al fragment Autompensante
        val view = inflater.inflate(R.layout.fragment_cloracion,container,false)

        val button = view.findViewById<Button>(R.id.btnautocompensant)
        button.setOnClickListener {
            // Iniciar la nueva actividad
            val intent = Intent(requireContext(), calculo_caudalActivity::class.java)
            intent.putExtra("titulo_toolbar", "Calculo Caudal")
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return view
    }


}