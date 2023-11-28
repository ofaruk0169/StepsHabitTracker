package com.example.stepshabittracker

import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {

    public var currentStreak: Int = 0
    private var isTimerRinning: Boolean = false

    //the timer should be called as soon as the application is started for the first time
    fun startTimer() {

    }
    //else timer should continue as normal

}