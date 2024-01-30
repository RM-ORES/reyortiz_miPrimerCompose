package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.modelo.Sustancia
import data.SustanciaRepository
import data.modelo.toSustanciaEntity
import javax.inject.Inject


class AddSustanciaUsecase @Inject constructor(
    val sustanciaRepository: SustanciaRepository,
) {
operator fun invoke(sustancia: Sustancia) = sustanciaRepository.insertSustancia(sustancia.toSustanciaEntity())
}