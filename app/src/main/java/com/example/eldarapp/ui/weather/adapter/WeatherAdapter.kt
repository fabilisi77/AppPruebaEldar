package com.example.eldarapp.ui.weather.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eldarapp.core.BaseViewHolder
import com.example.eldarapp.data.model.weather.Forecast
import com.example.eldarapp.data.model.weather.WeatherForecast
import com.example.eldarapp.databinding.ItemWeatherBinding
import com.example.eldarapp.utils.Utils

class WeatherAdapter(private val weatherList: List<Forecast> = listOf()) :
    RecyclerView.Adapter<BaseViewHolder<Forecast>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Forecast> {
        val itemBinding =
            ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = WeatherViewHolder(itemBinding, parent.context)

        return holder
    }

    override fun getItemCount(): Int = weatherList.size

    override fun onBindViewHolder(holder: BaseViewHolder<Forecast>, position: Int) {
        val item = weatherList[position]
        when (holder) {
            is WeatherViewHolder -> holder.bind(item)
        }
    }

    private inner class WeatherViewHolder(val binding: ItemWeatherBinding, val context: Context) :
        BaseViewHolder<Forecast>(binding.root) {


        override fun bind(item: Forecast) {
            binding.tvMainHourly.text = item.weather[0].main
            binding.tvDescriptionHourly.text = item.weather[0].description
            binding.tvTempHourly.text = "${Utils.formatTemp(item.temp)}°C"
            binding.tvHumidityHourly.text = "Humidity: ${item.humidity}%"
            binding.tvDtHourly.text = "Hour: ${Utils.formatDt(item.dt)}"


        }
    }

    fun updateData(newData: List<Forecast>) {
        hourlyForecasts.clear()
        hourlyForecasts.addAll(newData)
        notifyDataSetChanged()
    }
}
