package com.example.eldarapp.ui.weather.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eldarapp.core.BaseViewHolder
import com.example.eldarapp.data.model.weather.WeatherForecastEntity
import com.example.eldarapp.databinding.ItemWeatherBinding

class WeatherAdapter(private val weatherList: MutableList<WeatherForecastEntity> = mutableListOf()) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    fun updateData(newData: List<WeatherForecastEntity>) {
        weatherList.clear()
        weatherList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = WeatherViewHolder(itemBinding, parent.context)

        return holder
    }

    override fun getItemCount(): Int = weatherList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is WeatherViewHolder -> holder.bind(weatherList[position])
        }
    }

    private inner class WeatherViewHolder(val binding: ItemWeatherBinding, val context: Context) :
        BaseViewHolder<WeatherForecastEntity>(binding.root) {
        override fun bind(item: WeatherForecastEntity) {
            binding.tvMain.text = item.current.weather[0].main
            binding.tvDescription.text = item.current.weather[0].description
            binding.tvTemp.text = "${item.current.temp}°C"
            binding.tvHumidity.text = "Humidity: ${item.current.humidity}%"
            binding.tvDt.text = item.current.dt.toString()

        }
    }
}