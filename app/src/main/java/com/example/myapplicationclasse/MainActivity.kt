package com.example.myapplicationclasse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editPeso:EditText
    private lateinit var editAltura:EditText
    private lateinit var btnCalcular:Button
    private lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPeso=findViewById(R.id.editPeso)
        editAltura=findViewById(R.id.editAltura)
        btnCalcular=findViewById(R.id.btnCalcular)
        textResultado=findViewById(R.id.textResultado)

        btnCalcular.setOnClickListener {
            calcularImc()
        }
    }

    private fun calcularImc() {
        val pesoStr=editPeso.text.toString()
        val alturaStr=editAltura.text.toString()

        if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()){
            val peso=pesoStr.toFloat()
            val altura= alturaStr.toFloat()
            val imc=peso/ (altura * altura)
            val resultado=when{
                imc< 18.5 -> "Abaixo do peso"
                imc< 24.9 -> "Peso normal"
                imc< 29.9 -> "sobrepeso"
                imc< 34.9 -> "Obesidade grau 1"
                imc< 39.9 -> "Obesidade grau 2"
                else -> {"Obesidade grau 3"}
            }
            val mensagem= "Seu imc é %.2f, o que indica: $resultado".format(imc)
            textResultado.text=mensagem}
        else {textResultado.text="Preencha o peso e a altura"}
        }
    }
