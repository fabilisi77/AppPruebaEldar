package com.example.eldarapp.data.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eldarapp.data.model.weather.CurrentWeatherEntity
import com.example.eldarapp.data.model.weather.ForecastWeatherEntity
import com.example.eldarapp.data.model.weather.WeatherEntity
import com.example.eldarapp.data.model.weather.WeatherForecastEntity

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_forecast")
    suspend fun getWeatherForecastByCoordinates(): List<WeatherForecastEntityWithDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeather(weather: WeatherForecastEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCurrentWeather(currentWeather: CurrentWeatherEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveForecastWeather(forecastWeather: ForecastWeatherEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeatherEntity(weatherEntity: WeatherEntity)
}