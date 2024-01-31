package com.example.reyortiz_primercompose.ui

import com.example.myapplication.domain.modelo.Sustancia

sealed class MainEvent {
//    object CambiarModo : MainEvent()
    object ErrorVisto : MainEvent()
    object GetSustancias : MainEvent()
    object Next :MainEvent()
    object Previous : MainEvent()
    class AddSustancia(val sustancia: Sustancia) : MainEvent()
    class UpdateSustancia(val sustancia: Sustancia) : MainEvent()
    class DeleteSustancia(val sustancia: Sustancia) : MainEvent()


}
