package com.example.myapplication.domain.usecases

import data.SustanciaRepository
import javax.inject.Inject


class GetSustanciaUsecase @Inject constructor(
    private val sustanciaRepository: SustanciaRepository,
) {
    operator fun invoke(id: Int) = sustanciaRepository.getSustanciaById(id)
}