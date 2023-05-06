package com.example.mv4.bases

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.mv4.R
import com.example.mv4.calculoVolumen.rc_t
import com.google.android.material.textfield.TextInputEditText

class base_t_rc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_t_rc)


        // Obtener el título del toolbar del intent
        val toolbarTitle = intent.getStringExtra("titulo_toolbar")

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = toolbarTitle

        val longitudin =  findViewById<TextInputEditText>(R.id.inputLongitudTuberia)
        val diametroin = findViewById<TextInputEditText>(R.id.inputDiametroTuberia)
        val calcular = findViewById<Button>(R.id.buttonCalcTuberias)
        val resultadot = findViewById<TextView>(R.id.resultadoVolumenTuberia)

        calcular.setOnClickListener {
            if (longitudin.text.isNullOrEmpty() || diametroin.text.isNullOrEmpty()) {
                Toast.makeText(this, "Tiene que rellenar todos los datos", Toast.LENGTH_SHORT)
                    .show()
            }else{
            rc_t.nombre_toolbar(supportActionBar?.title.toString(),longitudin, diametroin,resultadot)
                ocultarTecladoUI.ocultarTeclado(this)
                mostrarLinear()

            }
        }


}
    private var linearLayoutVisible = true

    fun mostrarLinear(){
        val myLinearLayout = findViewById<LinearLayout>(R.id.linearResultadorc_v)
        if (linearLayoutVisible) { // comprobar si el layout está visible
            myLinearLayout.visibility = View.VISIBLE
            linearLayoutVisible = true // cambiar el estado del layout a invisible
        } else {
            myLinearLayout.visibility = View.GONE
        }
    }

}