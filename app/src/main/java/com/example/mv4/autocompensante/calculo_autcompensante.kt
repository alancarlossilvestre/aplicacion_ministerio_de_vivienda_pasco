package com.example.mv4.autocompensante

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.mv4.R
import com.example.mv4.calculo_caudalActivity
import com.google.android.material.textfield.TextInputEditText

class calculo_autcompensante : AppCompatActivity() {
    private lateinit var inputHipocloritoCalcio: TextInputEditText
    private lateinit var inputConcentracion: TextInputEditText
    private lateinit var inputCapacidadRotoPlast: TextInputEditText
    private lateinit var inputCaudalGoteo: TextInputEditText
    private lateinit var inputDias: TextInputEditText
    private lateinit var bntCalcularAutocom: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_autcompensante)

        // Obtener el título del toolbar del intent
        val toolbarTitle = "Cálculo Autocompensante"

        // Establecer el título del toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = toolbarTitle

        //obtener el caudal
        val resultadoCaudal= intent.getDoubleExtra("resultadoCaudal", 0.0)

        val mostrarValorCaudal = findViewById<TextView>(R.id.caudalRecibido)

        mostrarValorCaudal.text = "%.2f l/seg".format(resultadoCaudal)


        bntCalcularAutocom = findViewById(R.id.btnCalCloracion)

        bntCalcularAutocom.setOnClickListener {
            calculoAutocompensante(resultadoCaudal)
        }



    }

    private fun calculoAutocompensante(resultadoCaudal:Double){
        inputHipocloritoCalcio= findViewById(R.id.inputHipocloritoCalcio)
        inputConcentracion = findViewById(R.id.inputConcentracion)
        inputCapacidadRotoPlast = findViewById(R.id.inputCapcidadRotoplast)
        inputCaudalGoteo = findViewById(R.id.inputCaudalGoteo)
        inputDias =  findViewById(R.id.inputDías)
        val caudalReservorio = findViewById<TextView>(R.id.caudalRecibido)
        val viewResolucionMadre = findViewById<TextView>(R.id.resolucionMadre)


        val hipcocloritoC = inputHipocloritoCalcio.text.toString().toFloat()
        val concentracion = inputConcentracion.text.toString().toFloat()
        val capacidadRP = inputCapacidadRotoPlast.text.toString().toFloat()
        val caudalGoteo = inputCaudalGoteo.text.toString().toFloat()
       // val caudalResevorio = caudalReservorio.text.toString().toFloat()
        val dias = inputDias.text.toString().toFloat()
        val diasT= dias*86400


        val resultadoSolucionMadre = (dias*((resultadoCaudal*diasT)*concentracion/(10*hipcocloritoC)))*1000*1000*hipcocloritoC/100

        viewResolucionMadre.text = "Concentración de la solución madre: \n %.2f ".format(resultadoSolucionMadre)

        mostrarLinear()
        ocultarTecladoUI.ocultarTeclado(this)


        val btnCopy = findViewById<Button>(R.id.botonCopiarCloracion)
        btnCopy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val text = "***********\n${viewResolucionMadre.text}\n\n***********\n"
            clipboard.setPrimaryClip(ClipData.newPlainText("text", text))
        }

    }
    private var linearLayoutVisible = true
    fun mostrarLinear(){
        val myLinearLayout = findViewById<LinearLayout>(R.id.linearCloracion)
        if (linearLayoutVisible) { // comprobar si el layout está visible
            myLinearLayout.visibility = View.VISIBLE
            linearLayoutVisible = true // cambiar el estado del layout a invisible
        } else {
            myLinearLayout.visibility = View.GONE
        }
    }


}