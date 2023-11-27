package com.example.stepshabittracker


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*


class TimerViewModel : ViewModel() {
    private var currentStreak: Int = 0
    private var isTimerRunning: Boolean = false

    // Coroutine scope for the ViewModel
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    // Function to start the timer and fetch data from API
    fun startTasks() {
        if (!isTimerRunning) {
            isTimerRunning = true
            viewModelScope.launch {
                runTimer()
                fetchDataFromApi()
            }
        }
    }

    // Coroutine function to handle the timer logic
    private suspend fun runTimer() {
        while (isTimerRunning) {
            // Update timer-related data or UI
            currentStreak++
            // Simulate a delay of 1 second
            delay(1000)
        }
    }

    // Coroutine function to fetch data from API
    private suspend fun fetchDataFromApi() {
        // Make API call or perform data fetching here
        // For example, using Retrofit for simplicity
        //val apiService = ApiService.create()
        //val data = apiService.getData()
        // Handle the fetched data as needed
    }

    // Function to stop the timer
    fun stopTasks() {
        isTimerRunning = false
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel() // Cancel the coroutine scope when ViewModel is cleared
    }
}
