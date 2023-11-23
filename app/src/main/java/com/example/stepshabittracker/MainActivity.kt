package com.example.stepshabittracker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.example.stepshabittracker.databinding.ActivityMainBinding
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Reference the TextView and Button
        val streakTimeMinutesTextView = findViewById<TextView>(R.id.streakTimeMinutes)
        val changeTextButton = findViewById<Button>(R.id.resetButton)

        // Set a click listener for the button
        changeTextButton.setOnClickListener {
            // Change the text of the TextView when the button is clicked
            streakTimeMinutesTextView.text = "New Text"
        }



    }



}
