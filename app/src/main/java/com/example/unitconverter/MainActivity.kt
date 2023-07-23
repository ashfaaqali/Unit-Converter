package com.example.unitconverter

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.set
import com.example.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

            ArrayAdapter.createFromResource(
                this,
                R.array.units,
                android.R.layout.simple_spinner_item
            ).also { arrayAdapter ->
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinner1.adapter = arrayAdapter
            }

            binding.spinner1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val choice = parent?.getItemAtPosition(position) as String

                    binding.button.setOnClickListener{

                        if (choice=="KG To Pound"){

                            if (binding.unitInput.text.isEmpty()){
                                binding.unitInput.setText("")
                            } else{
                                val editTextVal = binding.unitInput.text.toString().toFloat()
                                val pound: Float = editTextVal * 2.20462262.toFloat()
                                binding.resultTextView.visibility = View.VISIBLE
                                binding.resultTextView.setText("The value in Pound is " + "%.3f".format(pound))
                                Toast.makeText(applicationContext, "The value in Pound is " + "%.3f".format(pound), Toast.LENGTH_LONG).show()
                            }
                        }

                        if (choice=="Pound To KG"){
                            if (binding.unitInput.text.isEmpty()){
                                binding.unitInput.setText("")
                            } else{
                                val editTextVal = binding.unitInput.text.toString().toFloat()
                                val kg: Float = editTextVal * 0.45359237.toFloat()
                                binding.resultTextView.visibility = View.VISIBLE
                                binding.resultTextView.setText("The value in Pound is " + "%.3f".format(kg))
                                Toast.makeText(applicationContext, "The value in KG is " + "%.2f".format(kg), Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }
}
