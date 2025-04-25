package com.isac.calculadora

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.isac.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Lista
        val items = listOf("masculino", "feminino")

        //objeto adapter
        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items)

        binding.spinnerGenero.adapter = adapter

        binding.buttonCalcular.setOnClickListener {
            val generoSelecionado = binding.spinnerGenero.selectedItem as String
            var idade = binding.textoDgtidade.text.toString().toLongOrNull()
            var resultado: Long
            var res: Long
            if (idade != null){


                if (generoSelecionado.trim()=="masculino"){
                    resultado = 65 - idade
                    res = idade - 65



                }else{
                    resultado = 62 - idade
                    res = idade - 62
                }
                if (idade > 65){

                    binding.textVerResultado.text="parabens, você se aposentou há $res anos"
                }else{
                    binding.textVerResultado.text="ainda falta $resultado anos para sua aposentadoria"}
                if (idade > 65){

                    binding.textVerResultado.text="parabens, você se aposentou há $res anos"
                }else{
                    binding.textVerResultado.text="ainda falta $resultado anos para sua aposentadoria"

                }



            }else{
                //mostra erro caso seja nulo
                binding.textVerResultado.text="informe sua idade: "
            }
        }

    }
}