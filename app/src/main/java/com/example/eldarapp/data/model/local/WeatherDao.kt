package com.example.eldarapp.data.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eldarapp.data.model.weather.WeatherForecastEntity

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather_forecast")
    suspend fun getWeatherForecastByCoordinates(): List<WeatherForecastEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeather(weather: WeatherForecastEntity)
}