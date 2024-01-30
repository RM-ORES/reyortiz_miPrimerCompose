package com.example.myapplication.domain.modelo

import java.time.LocalDate

data class Sustancia(
    val id: Int=0,
    var descripcion: String = "",
    var fecha: LocalDate? = null,
    var precio: Int? = 0,
    var legal: Boolean? = false,
    var efecto: String? = null,
    var potencia: Int? = 0,
    var valoracion: Int? = 0,
)