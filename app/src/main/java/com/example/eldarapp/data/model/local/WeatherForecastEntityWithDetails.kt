package com.example.eldarapp.data.model.local

import androidx.room.Embedded
import androidx.room.Relation
import com.example.eldarapp.data.model.weather.CurrentWeatherEntity
import com.example.eldarapp.data.model.weather.ForecastWeatherEntity
import com.example.eldarapp.data.model.weather.WeatherEntity
import com.example.eldarapp.data.model.weather.WeatherForecastEntity

data class WeatherForecastEntityWithDetails(
    @Embedded
    val weatherForecast: WeatherForecastEntity,

    @Relation(parentColumn = "id", entityColumn = "parent_id")
    val currentWeather: List<CurrentWeatherEntity>,

    @Relation(parentColumn = "id", entityColumn = "parent_id")
    val forecastWeather: List<ForecastWeatherEntity>,

    @Relation(parentColumn = "id", entityColumn = "parent_id")
    val weatherEntities: List<WeatherEntity>
)
