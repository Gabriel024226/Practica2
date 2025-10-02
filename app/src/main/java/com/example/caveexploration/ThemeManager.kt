package com.example.caveexploration

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

class ThemeManager(context: Context) {
    // SharedPreferences: Almacenamiento local persistente para guardar preferencias del usuario
    // Se utiliza aquí para mantener la selección de tema (día/noche) entre sesiones de la app
    private val prefs: SharedPreferences =
        context.getSharedPreferences("cave_prefs", Context.MODE_PRIVATE)
    // "cave_prefs" es el nombre del archivo de preferencias
    // MODE_PRIVATE asegura que solo esta app puede acceder a estos datos

    companion object {
        // Constante que actúa como clave para almacenar/recuperar el estado del modo oscuro
        private const val KEY_DARK_MODE = "isDarkModeEnabled"
    }

    // Propiedad que maneja el estado del modo oscuro
    var isDarkMode: Boolean
        // getter: Lee el valor almacenado en SharedPreferences
        // Si no existe, retorna false como valor predeterminado
        get() = prefs.getBoolean(KEY_DARK_MODE, false)
        
        // setter: Guarda el nuevo valor en SharedPreferences y aplica el tema
        set(value) {
            // edit() obtiene un editor para modificar las preferencias
            // putBoolean() almacena el valor booleano
            // apply() guarda los cambios de forma asíncrona (no bloquea el hilo principal)
            prefs.edit().putBoolean(KEY_DARK_MODE, value).apply()
            applyTheme(value)
        }

    // Aplica el tema a nivel de aplicación usando AppCompatDelegate
    fun applyTheme(isDark: Boolean) {
        AppCompatDelegate.setDefaultNightMode(
            if (isDark) AppCompatDelegate.MODE_NIGHT_YES  // Fuerza modo oscuro
            else AppCompatDelegate.MODE_NIGHT_NO          // Fuerza modo claro
        )
    }

    // Inicializa el tema al crear la actividad
    // Lee la preferencia guardada y aplica el tema correspondiente
    fun initTheme() {
        applyTheme(isDarkMode)
    }
}
