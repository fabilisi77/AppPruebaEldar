package com.example.eldarapp.ui.weather.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.eldarapp.data.model.weather.Forecast

class WeatherDiffCallback(
    private val oldList: List<Forecast>,
    private val newList: List<Forecast>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].dt == newList[newItemPosition].dt
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}