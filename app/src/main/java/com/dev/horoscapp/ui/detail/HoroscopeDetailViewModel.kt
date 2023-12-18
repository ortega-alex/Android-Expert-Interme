package com.dev.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.horoscapp.domain.model.HoroscopeModel
import com.dev.horoscapp.domain.usecase.GetPredictionUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUserCase: GetPredictionUserCase) :
    ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscopeModel: HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel) {
        horoscopeModel = sign
        viewModelScope.launch {
            // todo lo que se ejecuta aqui es el hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result =
                withContext(Dispatchers.IO) { getPredictionUserCase(sign.name) } // hilo segundario
            if (result != null) {
                _state.value = HoroscopeDetailState.Success(
                    result.horoscope,
                    result.sign,
                    horoscopeModel = horoscopeModel
                )
            } else {
                _state.value =
                    HoroscopeDetailState.Error("Ha ocurrido un error intentelo mas tarde")
            }
        }
    }
}