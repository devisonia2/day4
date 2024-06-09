package com.sonia.day4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var name: EditText? = null
    var number: EditText? = null
    var birthdate: EditText? = null
    var yes: RadioButton? = null
    var no: RadioButton? = null
    var enterYourCollegename: EditText? = null
    var move: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name)
        number = findViewById(R.id.number)
        birthdate = findViewById(R.id.birthdate)
        yes = findViewById(R.id.rbYes)
        no = findViewById(R.id.rbNo)
        enterYourCollegename = findViewById(R.id.collegename)
        move = findViewById(R.id.button)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        yes?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                enterYourCollegename?.visibility = View.VISIBLE
            } else {
                enterYourCollegename?.visibility = View.GONE
            }
        move?.setOnClickListener {
            if (name?.text?.trim().isNullOrEmpty()) {
                name?.error = "enter your name"
            } else if (number?.text?.trim().isNullOrEmpty()) {
                number?.error = "enter your number"
            } else if ((number?.text?.trim()?.length ?: 0) < 10) {
                number?.error = "Number should be of 10 digits"
            } else if (birthdate?.text?.trim().isNullOrEmpty()) {
                birthdate?.error = "enter your birthdate"
            } else {
                var intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name", name?.text?.toString()?.trim())
                intent.putExtra("number", number?.text?.toString()?.trim())
                intent.putExtra("birthdate", birthdate?.text?.toString()?.toInt())
                startActivity(intent)
            }
            yes?.setOnClickListener {
                Toast.makeText(this, "yes is clicked", Toast.LENGTH_SHORT).show()
            }

                }
            }
        }
}



