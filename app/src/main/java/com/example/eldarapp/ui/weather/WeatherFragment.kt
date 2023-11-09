package com.example.eldarapp.ui.weather

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.eldarapp.R
import com.example.eldarapp.core.Result
import com.example.eldarapp.data.remote.WeatherDataSource
import com.example.eldarapp.databinding.FragmentWeatherBinding
import com.example.eldarapp.presentation.weather.WeatherViewModel
import com.example.eldarapp.presentation.weather.WeatherViewModelFactory
import com.example.eldarapp.repository.weather.RetrofitClient
import com.example.eldarapp.repository.weather.WeatherRepositoryImpl
import com.example.eldarapp.ui.weather.adapter.WeatherAdapter
import com.example.eldarapp.utils.Constants
import com.example.eldarapp.utils.Utils
import com.example.eldarapp.utils.WeatherConfig

class WeatherFragment : Fragment(R.layout.fragment_weather) {
    private lateinit var binding: FragmentWeatherBinding
    private val viewModel by viewModels<WeatherViewModel> {
        WeatherViewModelFactory(
            WeatherRepositoryImpl(
                WeatherDataSource(RetrofitClient.webservice)
            )
        )
    }
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWeatherBinding.bind(view)
        weatherAdapter = WeatherAdapter()
        binding.recyclerView.adapter = weatherAdapter


        val lat = WeatherConfig.LATITUDE
        val lon = WeatherConfig.LONGITUDE
        val appId = WeatherConfig.API_KEY
        val exclude = WeatherConfig.EXCLUDE
        val units = WeatherConfig.UNITS
        val lang = WeatherConfig.LANG


        viewModel.fetchWeatherCurrent(lat, lon, appId, exclude, units, lang)
            .observe(viewLifecycleOwner, Observer { result ->
                when (result) {
                    is Result.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE

                    }

                    is Result.Success -> {
                        binding.progressBar.visibility = View.GONE

                        Glide.with(binding.root)
                            .load("${Constants.URL_IMAGE}${result.data.current.weather[0].icon}.png")
                            .into(binding.icon)
                        val weatherList = result.data.hourly
                        weatherAdapter.setData(weatherList)
                        binding.title.visibility = View.VISIBLE


                        binding.tvTimeZone.text = Utils.formatTimeZone(result.data.timezone)
                        binding.date.text = Utils.formatDate(result.data.current.dt)
                        binding.Temp.text = getString(R.string.temperature_format, Utils.formatTemp(result.data.current.temp).toInt())
                        binding.dt.text = getString(R.string.hour_format, Utils.formatDt(result.data.current.dt))
                        binding.Humidity.text = getString(R.string.humidity_format, result.data.current.humidity)
                        binding.Main.text = result.data.current.weather[0].main
                        binding.Description.text = result.data.current.weather[0].description
                    }

                    is Result.Failure -> {
                        binding.progressBar.visibility = View.GONE

                    }
                }
            })
    }
}

