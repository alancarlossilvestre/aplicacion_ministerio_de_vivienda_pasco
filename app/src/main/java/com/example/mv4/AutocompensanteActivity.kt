package com.example.mv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import com.example.mv4.caudalautocompensante.InputManager


class AutocompensanteActivity : AppCompatActivity() {
    private lateinit var container: LinearLayout
    private lateinit var addButton: AppCompatImageView
    private lateinit var inputManager: InputManager
    private lateinit var deletButton: AppCompatImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autocompensante)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        container = findViewById(R.id.textInputContainer)
        addButton = findViewById(R.id.add)
        deletButton = findViewById(R.id.quitar)

        inputManager = InputManager(container)

        addButton.setOnClickListener {
            inputManager.addNewInput()
        }
        deletButton.setOnClickListener {
            inputManager.deleteLastInput()
        }
    }

}