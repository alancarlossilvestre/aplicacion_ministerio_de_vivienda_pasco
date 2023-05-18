package com.example.mv4.caudalautocompensante

import android.widget.LinearLayout
import com.google.android.material.textfield.TextInputEditText

class calculaCaudar {
    fun calculateSum(container: LinearLayout): Double {
        var sum = 0.0
        val count = container.childCount
        for (i in 0 until count) {
            val view = container.getChildAt(i)
            if (view is TextInputEditText) {
                val text = view.text.toString()
                if (text.isNotEmpty()) {
                    val number = text.toDoubleOrNull()
                    if (number != null) {
                        sum += number
                    }
                }
            }
        }
        return sum
    }


    fun calculateAverage(container: LinearLayout): Double {
        val count = container.childCount
        val sum = calculateSum(container)
        return if (count != 0) {
            sum.toDouble() / count
        } else {
            0.0
        }
    }
}