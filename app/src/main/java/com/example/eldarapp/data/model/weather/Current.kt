package com.example.eldarapp.data.model.weather

data class Current(
    val dt: Long,
    val humidity: Int,
    val temp: Double,
    val weather: List<Weather>
)
