package com.juanviana.resistencias

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juanviana.resistencias.databinding.ActivityMainBinding

private lateinit var mainBinding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.botonCalcular.setOnClickListener {
            val banda1 = mainBinding.banda1Spinner.selectedItem.toString()
            val banda2 = mainBinding.banda2Spinner.selectedItem.toString()
            val tolerancia = mainBinding.banda3Spinner.selectedItem.toString()
            val error = mainBinding.errorSpinner.selectedItem.toString()
            calculos(banda1, banda2, tolerancia, error)


        }
    }

    private fun calculos(banda1: String, banda2: String, tol: String, error: String) {
        var concate = ""

        when (banda1) {
            "Marron" -> concate = "1"
            "Rojo" -> concate = "2"
            "Naranja" -> concate = "3"
            "Amarillo" -> concate = "4"
            "Verde" -> concate = "5"
            "Azul" -> concate = "6"
            "Violeta" -> concate = "7"
            "Gris" -> concate = "8"
            "Blanco" -> concate = "9"
        }
        when (banda2) {
            "Negro" -> concate += "0"
            "Marron" -> concate += "1"
            "Rojo" -> concate += "2"
            "Naranja" -> concate += "3"
            "Amarillo" -> concate += "4"
            "Verde" -> concate += "5"
            "Azul" -> concate += "6"
            "Violeta" -> concate += "7"
            "Gris" -> concate += "8"
            "Blanco" -> concate += "9"
        }

        if ((tol == "Verde") || tol == "Gris" || tol == "Oro" || (tol == "Rojo")) {
            var aux = concate.toFloat()
            val i = aux / 10
            concate = i.toString()
            when (tol) {
                "Rojo" -> concate += "kΩ"
                "Verde" -> concate += "MΩ"
                "Gris" -> concate += "GΩ"
                "Oro" -> concate += "Ω"

            }
        } else {
            when (tol) {
                "Negro" -> concate += "Ω"
                "Marron" -> concate += "0Ω"
                "Naranja" -> concate += "kΩ"
                "Amarillo" -> concate += "0kΩ"
                "Azul" -> concate += "MΩ"
                "Violeta" -> concate += "0MΩ"
                "Blanco" -> concate += "GΩ"
                "Plata" -> concate = "0.${concate}Ω"


            }
        }

        when (error) {
            "Marron" -> concate += " " + "±1%"
            "Rojo" -> concate += " " + "±2%"
            "Verde" -> concate += " " + "±0.5%"
            "Azul" -> concate += " " + "±0.25%"
            "Violeta" -> concate += " " + "±0.1%"
            "Gris" -> concate += " " + "±0.01%"
            "Oro" -> concate += " " + "±5%"
            "Plata" -> concate = " " + "±10%"
        }

        mainBinding.resultadoTextview.text = "El valor de su resistencia es de : " + concate
    }

}






