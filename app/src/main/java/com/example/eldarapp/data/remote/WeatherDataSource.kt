package com.example.eldarapp.data.remote

import com.example.eldarapp.data.model.weather.WeatherForecastEntity
import com.example.eldarapp.repository.weather.WebService
import com.example.eldarapp.utils.Constants

class WeatherDataSource(private val webService: WebService) {
    suspend fun getWeatherForecastByCoordinates(): WeatherForecastEntity {
        return webService.getWeatherForecastByCoordinates(
            Constants.LATITUDE_PARAM,
            Constants.LONGITUDE_PARAM,
            Constants.APP_ID_PARAM,
            Constants.EXCLUDE_PARAM,
            Constants.UNITS_PARAM,
            Constants.LANGUAGE_PARAM
        )
    }

}