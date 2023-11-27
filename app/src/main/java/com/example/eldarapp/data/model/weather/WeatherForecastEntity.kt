package com.example.eldarapp.data.model.weather

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_forecast")
data class WeatherForecastEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "timezone")
    val timezone: String,

    @ColumnInfo(name = "current_dt")
    val currentDt: Long,

    @ColumnInfo(name = "current_humidity")
    val currentHumidity: Int,

    @ColumnInfo(name = "current_temp")
    val currentTemp: Double,

    @ColumnInfo(name = "current_weather_main")
    val currentWeatherMain: String,

    @ColumnInfo(name = "current_weather_description")
    val currentWeatherDescription: String,

    @ColumnInfo(name = "current_weather_icon")
    val currentWeatherIcon: String
)

@Entity(tableName = "current_weather")
data class CurrentWeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "parent_id")
    val parentId: Long,

    @ColumnInfo(name = "dt")
    val dt: Long,

    @ColumnInfo(name = "humidity")
    val humidity: Int,

    @ColumnInfo(name = "temp")
    val temp: Double,

    @ColumnInfo(name = "weather_main")
    val weatherMain: String,

    @ColumnInfo(name = "weather_description")
    val weatherDescription: String,

    @ColumnInfo(name = "weather_icon")
    val weatherIcon: String
)

@Entity(tableName = "forecast_weather")
data class ForecastWeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "parent_id")
    val parentId: Long,

    @ColumnInfo(name = "dt")
    val dt: Long,

    @ColumnInfo(name = "humidity")
    val humidity: Int,

    @ColumnInfo(name = "temp")
    val temp: Double,

    @ColumnInfo(name = "weather_main")
    val weatherMain: String,

    @ColumnInfo(name = "weather_description")
    val weatherDescription: String,

    @ColumnInfo(name = "weather_icon")
    val weatherIcon: String
)

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "parent_id")
    val parentId: Long,

    @ColumnInfo(name = "main")
    val main: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "icon")
    val icon: String
)
