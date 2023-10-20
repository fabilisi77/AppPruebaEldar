package com.example.eldarapp.data.model.weather

import com.example.eldarapp.data.model.weather.Weather

data class Current(
    val dt: Long,
    val humidity: Int,
    val temp: Double,
    val weather: List<Weather>
)
