package com.example.myapplication.domain.usecases

import data.SustanciaRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetAllSustanciasUsecase @Inject constructor(
    private val sustanciaRepository: SustanciaRepository,
){
operator fun invoke() = sustanciaRepository.getSustancias()
}