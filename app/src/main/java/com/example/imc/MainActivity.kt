package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imc.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        usarbinding()

        binding.button.setOnClickListener {
            calcular()
        }

    }

    fun usarbinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun calcular() {
        val altura = binding.textAltura.text.toString().toDouble()
        val peso = binding.textPeso.text.toString().toDouble()

        val resultado = peso / (altura * altura)

        if (resultado <= 18.5) {
            binding.textResultado.setText("O seu resultado é %.2f".format(resultado) + ", sua classificação é: Magreza")
            binding.imgResultado.setImageResource(R.drawable.magreza)
        } else if (resultado >= 18.6 && resultado <= 24.9) {
            binding.textResultado.setText("O seu resultado é %.2f".format(resultado) + ", sua classificação é: Normal")
            binding.imgResultado.setImageResource(R.drawable.normal)
        } else if (resultado >= 25 && resultado <= 29.9) {
            binding.textResultado.setText("O seu resultado é %.2f".format(resultado) + ", sua classificação é: Sobrepeso (Obesidade I)")
            binding.imgResultado.setImageResource(R.drawable.obesidade1)
        } else if (resultado >= 30 && resultado <= 39.9) {
            binding.textResultado.setText("O seu resultado é %.2f".format(resultado) + ", sua classificação é: Obesidade II")
            binding.imgResultado.setImageResource(R.drawable.obesidade2)
        } else if (resultado >= 40) {
            binding.textResultado.setText("O seu resultado é %.2f".format(resultado) + ", sua classificação é: Obesidade III")
            binding.imgResultado.setImageResource(R.drawable.obesidade3)
        }
    }
}
