package com.dev.horoscapp.domain.usecase

import com.dev.horoscapp.domain.Repository
import javax.inject.Inject

class GetPredictionUserCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sing: String) = repository.getPrediction(sing)
}