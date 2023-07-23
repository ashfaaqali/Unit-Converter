package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var EditTextInput:EditText;
    lateinit var FromUnit:Spinner;
    lateinit var ToUnit:Spinner;
    lateinit var ConvertBtn:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EditTextInput = findViewById(R.id.unit_input);
        FromUnit = findViewById(R.id.spinner1);
        ToUnit = findViewById(R.id.spinner2);
        ConvertBtn = findViewById(R.id.button);

        ConvertBtn.setOnClickListener{
            Toast.makeText(this@MainActivity, "Test", Toast.LENGTH_LONG).show();
        }
    }
}
