package com.example.eldarapp.repository.weather

import com.example.eldarapp.data.model.weather.WeatherForecastEntity

interface WeatherRepository {
    suspend fun getWeatherForecastByCoordinates(
        lat: Double,
        lon: Double,
        exclude: String,
        units: String,
        lang: String
    ): WeatherForecastEntity
}