package com.example.eldarapp.utils

import android.icu.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    fun formatDt(dt: Long): String {
        val date = Date(dt * 1000L)
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return sdf.format(date)
    }

    fun formatTimeZone(timeZone: String): String {
        val parts = timeZone.split("/")
        if (parts.size >= 3) {
            val cityName = parts[2].replace("_", " ")
            return cityName
        }
        return timeZone
    }

     fun formatTemp(temp: Double): String {
        val temperature = temp.toInt()
        return temperature.toString()
    }

    fun formatDate(dt: Long): String {
        val date = Date(dt * 1000L)
        val sdf = SimpleDateFormat("E, d 'de' MMM", Locale.ENGLISH)
        return sdf.format(date)
    }
}