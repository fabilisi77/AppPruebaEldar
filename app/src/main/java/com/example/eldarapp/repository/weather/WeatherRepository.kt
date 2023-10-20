package com.example.eldarapp.repository.weather

import com.example.eldarapp.data.model.weather.WeatherForecastEntity

interface WeatherRepository {

    suspend fun getWeatherForecastByCoordinates(): WeatherForecastEntity
}