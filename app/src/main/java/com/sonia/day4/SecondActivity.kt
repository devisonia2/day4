package com.sonia.day4

import android.widget.Button
import android.widget.TextView
import com.sonia.day4.R
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    var tvname: TextView? = null
    var name = ""
    var tvnumber: TextView? = null
    var number = ""
    var tvbirthdate: TextView? = null
    var birthdate = ""
    var back: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        intent?.extras?.let {
            name = it.getString("name") ?: ""
            number = it.getString("number") ?: ""
            birthdate = it.getString("birthdate")?: ""
            println("name $name number $number birthdate $birthdate")
        }
        tvname = findViewById(R.id.name)
        tvname?.setText(name)
        tvnumber = findViewById(R.id.number)
        tvnumber?.setText(number)
        tvbirthdate = findViewById(R.id.dob)
        tvbirthdate?.setText(birthdate)
        back = findViewById(R.id.back)
    }
}



