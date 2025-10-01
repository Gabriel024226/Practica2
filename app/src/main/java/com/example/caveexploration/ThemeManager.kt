package com.example.caveexploration

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

class ThemeManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("cave_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_DARK_MODE = "isDarkModeEnabled"
    }

    var isDarkMode: Boolean
        get() = prefs.getBoolean(KEY_DARK_MODE, false)
        set(value) {
            prefs.edit().putBoolean(KEY_DARK_MODE, value).apply()
            applyTheme(value)
        }

    fun applyTheme(isDark: Boolean) {
        AppCompatDelegate.setDefaultNightMode(
            if (isDark) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
    }

    fun initTheme() {
        applyTheme(isDarkMode)
    }
}