package com.example.mv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import com.example.mv4.caudalautocompensante.InputManager
import com.example.mv4.caudalautocompensante.calculaCaudar
import com.google.android.material.textfield.TextInputEditText


class AutocompensanteActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_autocompensante)
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
            val sum = calculaCaudar.calculateSum(container)
            resultpromedioTextView.text = "Tiempo Promedio:\n %.2f Segundos".format(average)
            val Litros = VolRecipiente.text.toString().toDoubleOrNull()

            if (Litros != null) {
                val result = Litros / average
                resultadoCaudal.text = "Caudal: \n %.2f L/Seg" .format(result)
            } else {
                resultadoCaudal.text = "Ingrese un valor válido"
            }

        }

    }

}