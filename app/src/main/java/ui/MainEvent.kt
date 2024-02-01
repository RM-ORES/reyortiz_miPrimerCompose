package com.example.reyortiz_primercompose.ui

import com.example.myapplication.domain.modelo.Sustancia
import java.time.LocalDate

sealed class MainEvent {
//    object CambiarModo : MainEvent()
//    object ErrorVisto : MainEvent()
    object GetSustancias : MainEvent()
    object Next :MainEvent()
    object Previous : MainEvent()
    class AddSustancia(val sustancia: Sustancia) : MainEvent()
    class UpdateSustancia(val sustancia: Sustancia) : MainEvent()
    class DeleteSustancia(val sustancia: Sustancia) : MainEvent()
    class ChangeDescription(val valor :String) : MainEvent()
    class ChangeFecha(val valor :LocalDate) : MainEvent()
    class ChangePrecio(val valor :Int) : MainEvent()
    class ChangeLegal(val valor :Boolean) : MainEvent()
    class ChangeEfecto(val valor :String) : MainEvent()
    class ChangePotencia(val valor :Int) : MainEvent()
    class ChangeValoracion(val valor :Int) : MainEvent()


}
