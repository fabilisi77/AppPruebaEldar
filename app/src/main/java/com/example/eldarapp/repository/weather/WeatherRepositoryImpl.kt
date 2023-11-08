package com.example.eldarapp.repository.weather

import com.example.eldarapp.data.model.weather.WeatherForecast
import com.example.eldarapp.data.remote.WeatherDataSource

class WeatherRepositoryImpl(private val dataSource: WeatherDataSource) : WeatherRepository {
    override suspend fun getWeatherForecastByCoordinates(
        lat: Double,
        lon: Double,
        appId: String,
        exclude: String,
        units: String,
        lang: String

    ): WeatherForecast {

        return dataSource.getWeatherForecastByCoordinates(lat, lon, appId, exclude, units, lang)
    }
}