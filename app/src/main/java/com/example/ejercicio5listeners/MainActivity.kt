package com.example.ejercicio5listeners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.ejercicio5listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var contador = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.editTextTextPersonName.setOnFocusChangeListener{_,hasFocus ->
            if(hasFocus){
                binding.textView.text = binding.editTextTextPersonName.tag.toString()

            }
        }
        binding.editTextTextPersonName2.setOnFocusChangeListener{_,hasFocus ->
            if(hasFocus){
                binding.textView.text = binding.editTextTextPersonName2.tag.toString()

            }
        }


        //comprobar que el cuadro de texto esta vacio

        binding.editTextTextPersonName.addTextChangedListener {
            if (it.toString().isNotEmpty()) {
                binding.button.isEnabled = binding.editTextTextPersonName2.text.isNotEmpty()
            } else
                binding.button.isEnabled = false
        }

        binding.editTextTextPersonName2.addTextChangedListener {
            if (it.toString().isNotEmpty()) {
                binding.button.isEnabled = binding.editTextTextPersonName.text.isNotEmpty()
            } else
                binding.button.isEnabled = false
        }

        binding.button.setOnClickListener(){
            binding.editTextTextPersonName.text = binding.editTextTextPersonName.text.append(binding.editTextTextPersonName2.text)
            binding.editTextTextPersonName2.text.clear()
            binding.button.isEnabled=false
        }






    }
}