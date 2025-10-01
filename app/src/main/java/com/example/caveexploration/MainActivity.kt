package com.example.caveexploration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    private lateinit var themeManager: ThemeManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        themeManager = ThemeManager(this)
        themeManager.initTheme()

        setContentView(R.layout.activity_main)

        setupToolbar()
        setupThemeSwitch()
        setupUI()
        setupInteractiveElements()
    }

    private fun setupToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    private fun setupThemeSwitch() {
        val themeSwitch = findViewById<SwitchMaterial>(R.id.themeSwitch)
        themeSwitch.isChecked = themeManager.isDarkMode

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            themeManager.isDarkMode = isChecked
            recreate()
        }

        updateDayNightIndicator()
    }

    private fun setupUI() {
        val descriptionText = findViewById<TextView>(R.id.descriptionText)
        val isDarkMode = themeManager.isDarkMode

        descriptionText.text = buildString {
            append("Estás frente a una antigua cueva que se adentra en las profundidades de la montaña. ")
            append("La entrada está parcialmente cubierta por vegetación. ")
            if (isDarkMode) {
                append("La oscuridad de la noche hace que la cueva parezca aún más misteriosa.")
            } else {
                append("La luz del día ilumina suavemente la entrada.")
            }
        }

        findViewById<View>(R.id.enterButton).setOnClickListener {
            startActivity(Intent(this, FirstChamberActivity::class.java))
        }
    }

    private fun updateDayNightIndicator() {
        val indicator = findViewById<TextView>(R.id.dayNightIndicator)
        indicator.text = if (themeManager.isDarkMode) "🌙 Noche" else "☀️ Día"
    }

    private fun setupInteractiveElements() {
        setupInteractiveCard(
            R.id.rockFormation,
            "Formación Rocosa",
            "Las rocas de la entrada muestran signos de erosión milenaria.",
            "Formación Rocosa",
            "Las rocas de la entrada están formadas principalmente por caliza, " +
                    "un tipo de roca sedimentaria que se disuelve lentamente con el agua. " +
                    "Este proceso de erosión ha creado la caverna a lo largo de millones de años."
        )

        setupInteractiveCard(
            R.id.mossElement,
            "Musgo en las Paredes",
            "El musgo verde indica humedad constante en la cueva.",
            "Musgo de Cueva",
            "El musgo crece en las zonas donde llega algo de luz natural. " +
                    "Su presencia indica que estamos cerca de la entrada y que hay suficiente humedad " +
                    "en el ambiente para sostener vida vegetal."
        )
    }

    private fun setupInteractiveCard(
        cardId: Int,
        title: String,
        subtitle: String,
        dialogTitle: String,
        dialogContent: String
    ) {
        findViewById<CardView>(cardId).apply {
            findViewById<TextView>(R.id.elementTitle).text = title
            findViewById<TextView>(R.id.elementSubtitle).text = subtitle
            setOnClickListener {
                showInfoDialog(dialogTitle, dialogContent)
            }
        }
    }

    private fun showInfoDialog(title: String, content: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(content)
            .setPositiveButton(R.string.close, null)
            .show()
    }
}