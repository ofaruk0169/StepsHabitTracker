package com.example.stepshabittracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myStreakMinutes: TextView = findViewById(R.id.streakTimeMinutes)

        // I will now start a time
        //start the timer here
    }
}