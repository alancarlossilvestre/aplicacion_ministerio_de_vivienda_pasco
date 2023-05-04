package com.example.mv4.calculosdesinfeccion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.mv4.R

class CamaraRompePresion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camara_rompe_presion)
        showToolbar("Cámara Rompe Presión", true)
    }
    fun showToolbar(title: String, upButton: Boolean) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTitleText)
    }
}