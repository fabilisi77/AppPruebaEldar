package com.example.eldarapp.ui.weather.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eldarapp.core.BaseViewHolder
import com.example.eldarapp.data.model.weather.Forecast
import com.example.eldarapp.databinding.ItemWeatherBinding
import com.example.eldarapp.utils.Constants
import com.example.eldarapp.utils.Utils

class WeatherAdapter(private var weatherList: List<Forecast> = listOf()) :
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
            Glide.with(binding.root).load("${Constants.URL_IMAGE}${item.weather[0].icon}.png").into(binding.iconHourly)
            binding.tempHourly.text = "${Utils.formatTemp(item.temp)}°C"
            binding.DtHourly.text = Utils.formatDt(item.dt)
            binding.DateHourly.text = Utils.formatDate(item.dt)


        }
    }

    fun setData(newData: List<Forecast>) {
        weatherList = newData
        notifyDataSetChanged()

    }
}
