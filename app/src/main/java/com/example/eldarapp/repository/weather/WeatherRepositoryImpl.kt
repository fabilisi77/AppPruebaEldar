package com.example.eldarapp.repository.weather

import com.example.eldarapp.data.model.weather.WeatherForecastEntity
import com.example.eldarapp.data.remote.WeatherDataSource

class WeatherRepositoryImpl(private val dataSource: WeatherDataSource): WeatherRepository {
    override suspend fun getWeatherForecastByCoordinates(): WeatherForecastEntity {
        return dataSource.getWeatherForecastByCoordinates()
    }
}