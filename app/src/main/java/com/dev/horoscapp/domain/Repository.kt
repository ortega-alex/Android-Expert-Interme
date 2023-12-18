package com.dev.horoscapp.domain

import com.dev.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sing:String):PredictionModel?
}