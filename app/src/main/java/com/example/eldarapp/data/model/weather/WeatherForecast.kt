package com.example.eldarapp.data.model.weather

data class WeatherForecast(
    val timezone: String,
    val current: Current,
    val hourly: List<Forecast>
)

data class Current(
    val dt: Long,
    val humidity: Int,
    val temp: Double,
    val weather: List<Weather>
)

data class Forecast(
    val dt: Long,
    val humidity: Int,
    val temp: Double,
    val weather: List<Weather>
)

data class Weather(
    val main: String,
    val description: String,
    val icon: String
)

