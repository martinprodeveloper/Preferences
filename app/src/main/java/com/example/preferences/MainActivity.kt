package com.example.preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    lateinit var editTextName: EditText
    lateinit var switchAge: Switch
    lateinit var switchBuy: Switch
    lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.et_name)
        switchAge = findViewById(R.id.sw_age)
        switchBuy = findViewById(R.id.sw_buy)
        buttonSave = findViewById(R.id.btn_save)

        var prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE)
        editTextName.setText(prefs.getString("name", ""))
        switchAge.isChecked = prefs.getBoolean("age", false)
        switchBuy.isChecked = prefs.getBoolean("buy", false)

        buttonSave.setOnClickListener {

            val prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE)
            val editor = prefs.edit()

            editor.putString("name", editTextName.text.toString())
            editor.putBoolean("age", switchAge.isChecked)
            editor.putBoolean("buy", switchBuy.isChecked)
            editor.commit()

            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()
        }

    }
}