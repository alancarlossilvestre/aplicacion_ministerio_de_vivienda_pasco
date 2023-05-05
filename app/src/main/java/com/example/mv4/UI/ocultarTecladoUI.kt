import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class ocultarTecladoUI {
    companion object {
        fun ocultarTeclado(activity: Activity) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val currentFocus: View? = activity.currentFocus
            currentFocus?.let {
                imm.hideSoftInputFromWindow(it.windowToken, 0)
            }
        }
    }
}
