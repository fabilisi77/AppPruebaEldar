package com.example.eldarapp.repository.weather

import com.example.eldarapp.data.model.weather.WeatherForecastEntity
import com.example.eldarapp.data.remote.WeatherDataSource
import com.example.eldarapp.utils.Constants

class WeatherRepositoryImpl(private val dataSource: WeatherDataSource) : WeatherRepository {
    override suspend fun getWeatherForecastByCoordinates(
        lat: Double,
        lon: Double,
        exclude: String,
        units: String,
        lang: String
    ): WeatherForecastEntity {

        return dataSource.getWeatherForecastByCoordinates(lat, lon, exclude, units, lang)
    }
}