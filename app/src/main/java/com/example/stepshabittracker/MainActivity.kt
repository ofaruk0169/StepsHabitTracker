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

        // as soon as the application is started we need to call, TimerHandler()
        val timerHandlerClass = TimerHandler()
        timerHandlerClass.startTimer()

        //important buttons that are needed to interact with the application's UI.
        val streakTimeMinutesTextView = findViewById<TextView>(R.id.streakTimeMinutes)
        val changeTextButton = findViewById<Button>(R.id.resetButton)
        val startStreakButton = findViewById<Button>(R.id.startStopButton)


        //this is the button that is used to execute the change in the UI.
        changeTextButton.setOnClickListener {
            streakTimeMinutesTextView.text = "It's changed"
        }
    }
}
