package com.example.stepshabittracker
import android.os.Handler
import android.os.Looper

class TimerHandler(private val callback: (Int) -> Unit)
{
    private val mHandler = Handler(requireNotNull(Looper.myLooper()))
    public var currentStreak: Int = 0
    private var isTimerRunning: Boolean = false

    // the timer should be called as soon as the application is started for the first time
    fun startTimer() {
        // if the timer is not already running, start the timer
        if (!isTimerRunning) {
            isTimerRunning = true
            mHandler.postDelayed(timerRunnable, 1000) // Delayed by 1 second (1000 milliseconds)
        }
        // else the timer should continue as normal.
    }

    // Runnable to handle the timer logic
    private val timerRunnable: Runnable = object : Runnable {
        override fun run() {
            // Perform timer-related operations here
            currentStreak++
            // Log or update UI with the currentStreak value
            callback.invoke(currentStreak)
            // Continue the timer by posting the same Runnable with a delay
            mHandler.postDelayed(this, 1000) // Delayed by 1 second (1000 milliseconds)
        }
    }
}