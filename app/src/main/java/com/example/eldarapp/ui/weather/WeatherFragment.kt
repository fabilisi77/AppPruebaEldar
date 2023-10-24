package com.example.eldarapp.ui.weather

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.eldarapp.R
import com.example.eldarapp.core.Result
import com.example.eldarapp.data.remote.WeatherDataSource
import com.example.eldarapp.databinding.FragmentWeatherBinding
import com.example.eldarapp.presentation.weather.WeatherViewModel
import com.example.eldarapp.presentation.weather.WeatherViewModelFactory
import com.example.eldarapp.repository.weather.RetrofitClient
import com.example.eldarapp.repository.weather.WeatherRepositoryImpl

class WeatherFragment : Fragment(R.layout.fragment_weather) {
    private lateinit var binding: FragmentWeatherBinding
    private val viewModel by viewModels<WeatherViewModel> {
        WeatherViewModelFactory(
            WeatherRepositoryImpl(
                WeatherDataSource(RetrofitClient.webservice)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWeatherBinding.bind(view)

        val lat = 19.4325
        val lon = -99.1332
        val exclude = ""
        val units = "metric"
        val lang = "en"

        viewModel.fetchWeatherCurrent(lat, lon, exclude, units, lang).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    Log.d("Livedata", "Loading...")
                }

                is Result.Success -> {
                    Log.d("Livedata", "${result.data}")
                }

                is Result.Failure -> {
                    Log.d("Error", "${result.exception}")
                }
            }
        })
    }
}

