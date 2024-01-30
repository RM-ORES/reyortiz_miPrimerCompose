package com.example.reyortiz_primercompose.ui

import com.example.myapplication.domain.modelo.Sustancia

sealed class MainEvent{
    object GetSustancia : MainEvent()
    class AddSustancia(sustancia: Sustancia) : MainEvent()
    class UpdateSustancia(sustancia: Sustancia) : MainEvent()
    class DeleteSustancia(sustancia: Sustancia) : MainEvent()

}
