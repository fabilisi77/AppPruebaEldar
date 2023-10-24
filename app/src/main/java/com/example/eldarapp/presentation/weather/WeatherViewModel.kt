package com.example.eldarapp.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.eldarapp.core.Result
import com.example.eldarapp.repository.weather.WeatherRepository
import kotlinx.coroutines.Dispatchers

class WeatherViewModel(private val repo: WeatherRepository) : ViewModel() {

    fun fetchWeatherCurrent(
        lat: Double,
        lon: Double,
        exclude: String,
        units: String,
        lang: String
    ) = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(
                Result.Success(
                    repo.getWeatherForecastByCoordinates(
                        lat,
                        lon,
                        exclude,
                        units,
                        lang
                    )
                )
            )
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}

class WeatherViewModelFactory(private val repo: WeatherRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(WeatherRepository::class.java).newInstance(repo)
    }
}