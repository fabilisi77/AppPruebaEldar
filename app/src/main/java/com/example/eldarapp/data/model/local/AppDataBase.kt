package com.example.eldarapp.data.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eldarapp.data.model.weather.CurrentWeatherEntity
import com.example.eldarapp.data.model.weather.ForecastWeatherEntity
import com.example.eldarapp.data.model.weather.WeatherEntity
import com.example.eldarapp.data.model.weather.WeatherForecastEntity

@Database(
    entities = [WeatherForecastEntity::class, CurrentWeatherEntity::class, ForecastWeatherEntity::class, WeatherEntity::class],
    version = 2
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        fun getDataBase(context: Context): AppDataBase {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext, AppDataBase::class.java, "weather_table"
            ).build()
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}