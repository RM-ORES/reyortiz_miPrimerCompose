package com.example.myapplication.domain.usecases

import com.example.myapplication.domain.modelo.Sustancia
import data.SustanciaRepository
import data.modelo.toSustanciaEntity
import javax.inject.Inject


class DeleteSustanciaUsecase @Inject constructor(
    private val sustanciaRepository: SustanciaRepository,
) {
    operator fun invoke(sustancia: Sustancia) = sustanciaRepository.deleteSustancia(sustancia.toSustanciaEntity())
}