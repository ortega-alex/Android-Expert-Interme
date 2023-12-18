package com.dev.horoscapp.data

import android.util.Log
import com.dev.horoscapp.data.network.HoroscopeApiService
import com.dev.horoscapp.domain.Repository
import com.dev.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sing: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sing) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("aris", "Ha ocurrido un error ${it.message}") }
        return null
    }
}