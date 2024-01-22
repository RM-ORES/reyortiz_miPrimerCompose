package com.example.reyortiz_primercompose.ui

import com.example.myapplication.domain.modelo.Sustancia

data class MainState(
    val sustancia: Sustancia = Sustancia(),
    val error: String? = null,
)
