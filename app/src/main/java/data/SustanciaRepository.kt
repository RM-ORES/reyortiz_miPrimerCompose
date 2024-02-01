package data

import com.example.myapplication.domain.modelo.Sustancia
import data.modelo.SustanciaEntity
import data.modelo.toSustancia
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SustanciaRepository @Inject constructor(
    private val sustanciaDao: SustanciaDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,) {
    fun getSustancias(): Flow<List<Sustancia>> = flow { emit(sustanciaDao.getSustancias().map { it.toSustancia() }) }.flowOn(dispatcher)

    fun insertSustancia(sustanciaEntity: SustanciaEntity) = flow { emit(sustanciaDao.insert(sustanciaEntity)) }.flowOn(dispatcher)

    fun updateSustancia(sustanciaEntity: SustanciaEntity) = flow { emit(sustanciaDao.update(sustanciaEntity)) }.flowOn(dispatcher)

    fun deleteSustancia(sustanciaEntity: SustanciaEntity) = flow { emit(sustanciaDao.delete(sustanciaEntity))}.flowOn(dispatcher)
}