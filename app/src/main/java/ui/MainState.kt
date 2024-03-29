package com.example.reyortiz_primercompose.ui

import com.example.myapplication.domain.modelo.Sustancia
import java.time.LocalDate

data class MainState(
//    val editMode : Boolean = false,
    val sustancia: Sustancia? = null,
    val error: String? = null,
    val descripcion: String = "",
    val fecha: LocalDate? = null,
    var precio: Int? = 0,
    var legal: Boolean? = false,
    var efecto: String? = null,
    var potencia: Int? = 0,
    var valoracion: Int? = 0
)
