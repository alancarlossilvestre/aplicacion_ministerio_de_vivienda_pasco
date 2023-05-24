package com.example.mv4.autocompensante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.mv4.R
import com.example.mv4.calculo_caudalActivity

class calculo_autcompensante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_autcompensante)

        // Obtener el título del toolbar del intent
        val toolbarTitle = intent.getStringExtra("titulo_toolbar")

        // Establecer el título del toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = toolbarTitle

        //obtener el caudal
        val resultadoCaudal= intent.getDoubleExtra("resultadoCaudal", 0.0)

        val mostrarValorCaudal = findViewById<TextView>(R.id.caudalRecibido)

        mostrarValorCaudal.text = "%.2f l/seg".format(resultadoCaudal)


    }
}