package com.example.stepshabittracker


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val streakTimeMinutesTextView = findViewById<TextView>(R.id.streakTimeMinutes)
        val changeTextButton = findViewById<Button>(R.id.resetButton)

        changeTextButton.setOnClickListener {
            streakTimeMinutesTextView.text = "It's changed"
        }
    }
}
