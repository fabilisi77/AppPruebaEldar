package com.example.eldarapp.data.model.weather

data class WeatherForecastEntity(
    val timezone: String, val current: Current, val hourly: List<Forecast>?)
