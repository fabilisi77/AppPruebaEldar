package com.example.eldarapp.data.remote

import com.example.eldarapp.data.model.weather.WeatherForecast
import com.example.eldarapp.repository.weather.WebService

class WeatherDataSource(private val webService: WebService) {
    suspend fun getWeatherForecastByCoordinates(
        lat: Double,
        lon: Double,
        appId: String,
        exclude: String,
        units: String,
        lang: String

    ): WeatherForecast {
        return webService.getWeatherForecastByCoordinates(lat,lon,appId,exclude,units,lang)
    }
}