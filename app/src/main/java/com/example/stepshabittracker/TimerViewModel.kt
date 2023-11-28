package com.example.stepshabittracker

import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {

    //variables I must keep track of

    public var currentStreak: Int = 0
    private var isTimerRinning: Boolean = false

    //the timer should be called as soon as the application is started for the first time
    fun startTimer() {
        if(!isTimerRinning) {
            isTimerRinning = true
            //Coroutines function to continue running the timer
        }
    }
    //else timer should continue as normal


    fun stopTimer() {

    }

}