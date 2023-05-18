package com.example.mv4.caudalautocompensante

import android.view.View
import android.widget.LinearLayout
import com.google.android.material.textfield.TextInputEditText

class InputManager(private val container: LinearLayout) {

        private var inputCount = 1

        fun addNewInput() {
            val newInput = TextInputEditText(container.context)
            newInput.id = View.generateViewId()
            newInput.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            newInput.hint = "Toma $inputCount"
            container.addView(newInput)
            inputCount++
        }
        fun deleteLastInput() {
            val lastInputIndex = container.childCount - 1
            if (lastInputIndex >= 0) {
                container.removeViewAt(lastInputIndex)
                inputCount--
            }
        }

}