package com.example.caveexploration

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton

class LagoonChamberActivity : AppCompatActivity() {
    private lateinit var themeManager: ThemeManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        themeManager = ThemeManager(this)
        themeManager.initTheme()

        setContentView(R.layout.activity_lagoon_chamber)

        setupToolbar()
        setupUI()
        setupInteractiveElements()
        setupBackButton()
    }

    private fun setupToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupUI() {
        val description = findViewById<TextView>(R.id.lagoonDescription)
        val isDarkMode = themeManager.isDarkMode

        description.text = buildString {
            append("Has llegado a la cámara más profunda de la cueva. ")
            append("Aquí se encuentra una laguna subterránea de aguas cristalinas. ")
            if (isDarkMode) {
                append("En la oscuridad nocturna, el agua parece negra como el azabache y misteriosa. ")
            } else {
                append("Durante el día, alguna luz indirecta le da un tono azul turquesa al agua. ")
            }
            append("El sonido de gotas cayendo resuena en el silencio.")
        }
    }

    private fun setupInteractiveElements() {
        // Laguna Subterránea
        findViewById<CardView>(R.id.lagoonElement).apply {
            findViewById<TextView>(R.id.elementTitle).text = "Laguna Subterránea"
            findViewById<TextView>(R.id.elementSubtitle).text =
                "Agua cristalina acumulada durante siglos."
            setOnClickListener {
                showInfoDialog(
                    "Laguna Subterránea",
                    "Las lagunas subterráneas se forman por la acumulación de agua filtrada a través " +
                            "de las capas de roca durante miles de años. El agua de estas lagunas suele ser " +
                            "extremadamente pura y clara, ya que ha sido filtrada naturalmente por la roca caliza. " +
                            "La temperatura del agua permanece constante durante todo el año, típicamente entre 10-15°C. " +
                            "Estas lagunas pueden albergar ecosistemas únicos adaptados a la vida en completa oscuridad."
                )
            }
        }

        // Formaciones de Calcita
        findViewById<CardView>(R.id.calciteElement).apply {
            findViewById<TextView>(R.id.elementTitle).text = "Formaciones de Calcita"
            findViewById<TextView>(R.id.elementSubtitle).text =
                "Cristales brillantes en las paredes de la cueva."
            setOnClickListener {
                showInfoDialog(
                    "Formaciones de Calcita",
                    "La calcita es un mineral compuesto de carbonato de calcio que forma cristales transparentes " +
                            "o translúcidos. En las cuevas, la calcita puede formar estructuras cristalinas que brillan " +
                            "cuando se les ilumina. Estas formaciones pueden tomar diferentes formas: desde cristales " +
                            "puntiagudos hasta capas sedimentarias llamadas \"flowstone\" o piedra fluida. " +
                            "La calcita es el mineral principal que forma las estalactitas y estalagmitas."
                )
            }
        }

        // Helictitas
        findViewById<CardView>(R.id.helictitesElement).apply {
            findViewById<TextView>(R.id.elementTitle).text = "Helictitas"
            findViewById<TextView>(R.id.elementSubtitle).text =
                "Formaciones que desafían la gravedad."
            setOnClickListener {
                showInfoDialog(
                    "Helictitas",
                    "Las helictitas son formaciones extremadamente raras que parecen desafiar la gravedad. " +
                            "A diferencia de las estalactitas que crecen hacia abajo, las helictitas pueden crecer " +
                            "en cualquier dirección: hacia los lados, hacia arriba, o en espirales retorcidas. " +
                            "Se forman cuando el agua se filtra muy lentamente a través de canales microscópicos, " +
                            "y fuerzas como la tensión superficial y la presión del aire influyen más que la gravedad. " +
                            "Son tan delicadas que pueden romperse con una simple corriente de aire."
                )
            }
        }

        // Fauna de Cueva
        findViewById<CardView>(R.id.faunaElement).apply {
            findViewById<TextView>(R.id.elementTitle).text = "Fauna de Cueva"
            findViewById<TextView>(R.id.elementSubtitle).text =
                "Pequeños habitantes de la oscuridad."
            setOnClickListener {
                showInfoDialog(
                    "Fauna de Cueva",
                    "Las cuevas albergan fauna especializada llamada \"troglobios\", organismos que han evolucionado " +
                            "para vivir exclusivamente en la oscuridad. Estos animales suelen carecer de ojos y pigmentación. " +
                            "Incluyen: murciélagos (que usan las cuevas como refugio), peces ciegos, salamandras de cueva, " +
                            "arañas albinas, e invertebrados como los colémbolos. Algunos microorganismos incluso obtienen " +
                            "su energía de minerales en lugar del sol. Los ecosistemas de cuevas son extremadamente frágiles " +
                            "y sensibles a cambios en temperatura, humedad o contaminación."
                )
            }
        }
    }

    private fun setupBackButton() {
        findViewById<MaterialButton>(R.id.backToEntranceButton).setOnClickListener {
            // Crear un nuevo Intent para MainActivity y limpiar el stack
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
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