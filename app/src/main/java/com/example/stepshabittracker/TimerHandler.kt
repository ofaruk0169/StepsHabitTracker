package com.example.stepshabittracker
import android.os.Handler
import android.os.Looper

class TimerHandler
{
    private val mHandler = Handler(requireNotNull(Looper.myLooper()))

    // the timer should be called as soon as the application is started for the first time



    fun startTimer() {
        // if the timer is above 00:00:00 this function should not activate again
    }



}