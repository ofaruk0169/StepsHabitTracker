package com.example.stepshabittracker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import com.example.stepshabittracker.databinding.ActivityMainBinding
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var timerStarted = false
    private lateinit var serviceIntent: Intent
    private var time = 0.0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startStopButton.setOnClickListener { startStopTimer() }
        binding.resetButton.setOnClickListener { resetTimer() }

        serviceIntent = Intent(applicationContext, TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))

        Log.d("YourTag", "Broadcast receiver registered successfully")

    }

    private fun resetTimer()
    {
        stopTimer()
        time = 0.0
        binding.streakTimeMinutes.text = getTimeStringFromDouble(time)
    }

    private fun startStopTimer()
    {
        if(timerStarted)
            stopTimer()
        else
            startTimer()
    }

    private fun startTimer()
    {
        serviceIntent.putExtra(TimerService.TIME_EXTRA, time)
        startService(serviceIntent)
        binding.startStopButton.text = getString(R.string.stop)
        binding.startStopButton.icon = AppCompatResources.getDrawable(this, R.drawable.baseline_pause_24)
        timerStarted = true

        Log.d("YourTag", "Timer started")
    }

    private fun stopTimer()
    {
        stopService(serviceIntent)
        binding.startStopButton.text = getString(R.string.start)
        binding.startStopButton.icon = AppCompatResources.getDrawable(this, R.drawable.baseline_play_arrow_24)
        timerStarted = false

        Log.d("YourTag", "Timer stopped")
    }


    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                time = intent.getDoubleExtra(TimerService.TIME_EXTRA, 0.0)
                binding.streakTimeMinutes.text = getTimeStringFromDouble(time)
                Log.d("YourTag", "Time updated: $time")

            }
        }
    }

    private fun getTimeStringFromDouble(time: Double): String
    {
        val resultInt = time.roundToInt()
        val hours = resultInt / 3600
        val minutes = (resultInt % 3600) / 60
        val seconds = resultInt % 60

        return makeTimeString(hours, minutes, seconds)
    }

    private fun makeTimeString(hour: Int, min: Int, sec: Int): String = String.format("%02d:%02d:%02d", hour, min, sec)

}
