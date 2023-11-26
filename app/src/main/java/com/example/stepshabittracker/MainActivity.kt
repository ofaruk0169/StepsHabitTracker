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

        //important buttons that are needed to interact with the application's UI.
        val streakTimeMinutesTextView = findViewById<TextView>(R.id.streakTimeMinutes)
        val changeTextButton = findViewById<Button>(R.id.resetButton)

        // Create a callback to update the UI
        val updateUICallback: (Int) -> Unit = { currentStreak ->
            streakTimeMinutesTextView.text = "Current Streak: $currentStreak"
        }

        val timerHandlerClass = TimerHandler(updateUICallback)
        timerHandlerClass.startTimer()



        val startStreakButton = findViewById<Button>(R.id.startStopButton)


        //this is the button
        changeTextButton.setOnClickListener {

        }
    }
}
