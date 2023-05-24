package com.example.mv4

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
import androidx.appcompat.widget.AppCompatImageView
import com.example.mv4.autocompensante.calculo_autcompensante
import com.example.mv4.caudalautocompensante.InputManager
import com.example.mv4.caudalautocompensante.calculaCaudar
import com.google.android.material.textfield.TextInputEditText


class calculo_caudalActivity : AppCompatActivity() {
    private lateinit var container: LinearLayout
    private lateinit var addButton: AppCompatImageView
    private lateinit var inputManager: InputManager
    private lateinit var deletButton: AppCompatImageView
    private lateinit var sumButton: Button
    private lateinit var resultpromedioTextView: TextView
    private lateinit var resultadoCaudal: TextView
    private val calculaCaudar = calculaCaudar()
    private lateinit var VolRecipiente: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_caudal)
        // Obtener el título del toolbar del intent
        val toolbarTitle = intent.getStringExtra("titulo_toolbar")

        // Establecer el título del toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = toolbarTitle

        container = findViewById(R.id.textInputContainer)
        addButton = findViewById(R.id.add)
        deletButton = findViewById(R.id.quitar)
        sumButton = findViewById(R.id.buttonCalCaudalAgua)
        resultpromedioTextView = findViewById(R.id.resultadoTiempoPromedio)
        resultadoCaudal =  findViewById(R.id.resultadoCaudal)
        VolRecipiente  = findViewById(R.id.inputVolRecipCaudalAutocom)

        inputManager = InputManager(container)

        addButton.setOnClickListener {
            inputManager.addNewInput()
        }

        deletButton.setOnClickListener {
            inputManager.deleteLastInput()
        }

        sumButton.setOnClickListener {
            val average = calculaCaudar.calculateAverage(container)
            resultpromedioTextView.text = "Tiempo Promedio:\n %.2f Segundos".format(average)
            val Litros = VolRecipiente.text.toString().toDoubleOrNull()
            ocultarTecladoUI.ocultarTeclado(this)
            mostrarLinear()
            if (Litros != null) {
                val result = Litros / average
                resultadoCaudal.text = "Caudal: \n %.2f l/seg" .format(result)
                val intent = Intent(this,  calculo_autcompensante::class.java)
                ocultarTecladoUI.ocultarTeclado(this)
                mostrarLinear()
                val btnIrCalculoAutocom = findViewById<Button>(R.id.buttonIrCalculoAutocom)
                btnIrCalculoAutocom.setOnClickListener {
                    val intent = Intent(this, calculo_autcompensante::class.java)
                    intent.putExtra("resultadoCaudal", result)
                    intent.putExtra("titulo_toolbar", "Calculo Autocompensante")
                    startActivity(intent)

                }
            } else {
                resultadoCaudal.text = "Ingrese un valor válido"
                ocultarTecladoUI.ocultarTeclado(this)
                mostrarLinear()
            }


        }
        val btnCopy = findViewById<Button>(R.id.botonCopiarcaudal)
        btnCopy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val text = "***********\n${resultpromedioTextView.text}\n\n***********\n${resultadoCaudal.text}"
            clipboard.setPrimaryClip(ClipData.newPlainText("text", text))
        }

    }

    private var linearLayoutVisible = true
    fun mostrarLinear(){
        val myLinearLayout = findViewById<LinearLayout>(R.id.linearResultadocaudal)
        if (linearLayoutVisible) { // comprobar si el layout está visible
            myLinearLayout.visibility = View.VISIBLE
            linearLayoutVisible = true // cambiar el estado del layout a invisible
        } else {
            myLinearLayout.visibility = View.GONE
        }
    }
}