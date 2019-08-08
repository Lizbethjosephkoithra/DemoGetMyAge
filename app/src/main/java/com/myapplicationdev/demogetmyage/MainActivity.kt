package com.myapplicationdev.demogetmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAge.setOnClickListener {
            val birthYear = etYear.text.toString()
            if (birthYear.isNotEmpty()) {
                val year = Calendar.getInstance().get(Calendar.YEAR)
                val age = year - birthYear.toInt()
                tvAge.text = "Your age is $age"

                var output = ""
                when (age){
                    in 0..17 -> output = "Underage"
                    in 18..65 -> output = "Young people"
                    in 66..79 -> output = "Middle Aged"
                    in 80..99 -> output = "Elderly"
                    else ->{
                        output = "Long lived elderly"
                    }
                }
                tvSection.text = output
            }else{
                Toast.makeText(applicationContext,"Please enter your birth year",Toast.LENGTH_LONG).show()
            }

        }

    }
}
