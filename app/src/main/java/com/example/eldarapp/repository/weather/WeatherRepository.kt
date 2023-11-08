package com.example.eldarapp.repository.weather

import com.example.eldarapp.data.model.weather.WeatherForecast

interface WeatherRepository {
    suspend fun getWeatherForecastByCoordinates(
        lat: Double,
        lon: Double,
        appId: String,
        exclude: String,
        units: String,
        lang: String

    ): WeatherForecast
}