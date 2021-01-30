package com.example.preferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)
        saveButton.setOnClickListener{
            saveClick()
        }
    }

    fun saveClick(){
        val emailText = emailInput.text.toString()
        val firstName = firstInput.text.toString()
        val secondName = secondInput.text.toString()
        val addressText = addressInput.text.toString()
        val ageNumber = ageInput.text.toString()


        val edit = sharedPreferences.edit()
        if(emailInput.text.isNotEmpty() && firstInput.text.isNotEmpty() &&
            secondInput.text.isNotEmpty() && addressInput.text.isNotEmpty() &&
            ageInput.text.isNotEmpty()) {
            edit.putString("emailText", emailText)
            edit.putString("firstName", firstName)
            edit.putString("secondName", secondName)
            edit.putString("ageNumber", ageNumber)
            edit.putString("addressText", addressText)
            edit.apply()
        }

    }

    fun readClick(){
        emailInput.setText(sharedPreferences.getString("emailText", ""))
        firstInput.setText(sharedPreferences.getString("firstName", ""))
        secondInput.setText(sharedPreferences.getString("secondName", ""))
        ageInput.setText(sharedPreferences.getString("ageNumber", ""))
        addressInput.setText(sharedPreferences.getString("addressText", ""))
    }
}