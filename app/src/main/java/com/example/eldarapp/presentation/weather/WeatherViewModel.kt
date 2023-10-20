package com.example.eldarapp.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.eldarapp.core.Result
import com.example.eldarapp.repository.weather.WeatherRepository
import kotlinx.coroutines.Dispatchers

class WeatherViewModel(private val repo: WeatherRepository) : ViewModel() {

    fun fetchWeatherCurrent() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.getWeatherForecastByCoordinates()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }

    }
}