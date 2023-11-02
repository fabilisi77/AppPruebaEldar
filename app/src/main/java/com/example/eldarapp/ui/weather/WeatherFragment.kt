package com.example.eldarapp.ui.weather

import android.os.Bundle
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
import com.example.eldarapp.ui.weather.adapter.WeatherAdapter
import com.example.eldarapp.utils.Constants

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


        val lat = -34.91722
        val lon = -58.38694
        val appId = Constants.API_KEY
        val exclude = ""
        val units = "metric"
        val lang = "en"


        viewModel.fetchWeatherCurrent(lat, lon, appId, exclude, units, lang)
            .observe(viewLifecycleOwner, Observer { result ->
                when (result) {
                    is Result.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE

                    }

                    is Result.Success -> {
                        binding.progressBar.visibility = View.GONE
                        val data = result.data
                        weatherAdapter.updateData(listOf(data))

                    }

                    is Result.Failure -> {
                        binding.progressBar.visibility = View.GONE

                    }
                }
            })
    }
}

