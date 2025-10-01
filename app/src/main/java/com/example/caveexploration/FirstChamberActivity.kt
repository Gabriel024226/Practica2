package com.example.caveexploration

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.switchmaterial.SwitchMaterial

class FirstChamberActivity : AppCompatActivity() {
    private lateinit var themeManager: ThemeManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        themeManager = ThemeManager(this)
        themeManager.initTheme()

        // --- CORRECCIÓN ---
        // Mover setContentView() aquí, antes de acceder a cualquier vista.
        setContentView(R.layout.activity_first_chamber)

        setupToolbar()
        setupThemeSwitch()
        setupUI()
        setupInteractiveElements()
    }

    private fun setupToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupThemeSwitch() {
        val themeSwitch = findViewById<SwitchMaterial>(R.id.themeSwitch)
        themeSwitch.isChecked = themeManager.isDarkMode

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            themeManager.isDarkMode = isChecked
            recreate()
        }
    }

    private fun setupUI() {
        val description = findViewById<TextView>(R.id.chamberDescription)
        val isDarkMode = themeManager.isDarkMode

        description.text = buildString {
            append("Esta amplia cámara tiene un techo alto. ")
            if (isDarkMode) {
                append("En la oscuridad, apenas puedes distinguir las formaciones en el techo. ")
            } else {
                append("La luz que entra desde la entrada ilumina parcialmente las formaciones. ")
            }
            append("Puedes ver impresionantes estalactitas colgando del techo y estalagmitas emergiendo del suelo.")
        }

        // Configurar botón de pasaje
        findViewById<FrameLayout>(R.id.passageButton).setOnClickListener {
            startActivity(Intent(this, LagoonChamberActivity::class.java))
        }
    }

    private fun setupInteractiveElements() {
        // Estalactitas
        findViewById<CardView>(R.id.stalactitesElement).apply {
            findViewById<TextView>(R.id.elementTitle).text = "Estalactitas"
            findViewById<TextView>(R.id.elementSubtitle).text =
                "Formaciones que cuelgan del techo como carámbanos de piedra."
            setOnClickListener {
                showInfoDialog(
                    "Estalactitas",
                    "Las estalactitas son formaciones minerales que cuelgan del techo de las cuevas. " +
                            "Se forman cuando el agua rica en minerales gotea desde el techo, " +
                            "dejando depósitos de carbonato de calcio que crecen hacia abajo muy lentamente. " +
                            "Pueden tardar cientos o miles de años en formarse. " +
                            "La palabra proviene del griego \"stalaktos\" que significa \"goteo\"."
                )
            }
        }

        // Estalagmitas
        findViewById<CardView>(R.id.stalagmitesElement).apply {
            findViewById<TextView>(R.id.elementTitle).text = "Estalagmitas"
            findViewById<TextView>(R.id.elementSubtitle).text =
                "Formaciones que crecen desde el suelo hacia arriba."
            setOnClickListener {
                showInfoDialog(
                    "Estalagmitas",
                    "Las estalagmitas crecen desde el suelo de la cueva hacia arriba. " +
                            "Se forman cuando las gotas de agua que caen desde el techo depositan minerales en el suelo. " +
                            "Con el tiempo, estos depósitos se acumulan y crecen verticalmente. " +
                            "Un truco para recordarlas: \"estalagMitas\" tiene una M, y la M tiene puntas hacia arriba, " +
                            "igual que las estalagmitas crecen hacia arriba."
                )
            }
        }

        // Columnas
        findViewById<CardView>(R.id.columnsElement).apply {
            findViewById<TextView>(R.id.elementTitle).text = "Columnas"
            findViewById<TextView>(R.id.elementSubtitle).text =
                "Cuando estalactitas y estalagmitas se unen."
            setOnClickListener {
                showInfoDialog(
                    "Columnas de Cueva",
                    "Cuando una estalactita y una estalagmita se encuentran y se fusionan, " +
                            "forman una columna que va desde el techo hasta el suelo. " +
                            "Estas estructuras son muy raras y pueden tardar decenas de miles de años en formarse. " +
                            "Son una señal de que la cueva es muy antigua y estable."
                )
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
