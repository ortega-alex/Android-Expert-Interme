package com.dev.horoscapp.ui.detail

import com.dev.horoscapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    object Loading : HoroscopeDetailState()
    data class Error(val error: String) :
        HoroscopeDetailState() // cuando requiere parametos es una data class de lo contrario es un object

    data class Success(
        val prediction: String,
        val sing: String,
        val horoscopeModel: HoroscopeModel
    ) : HoroscopeDetailState()
}