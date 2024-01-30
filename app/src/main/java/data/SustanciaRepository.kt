package data

import com.example.myapplication.domain.modelo.Sustancia
import data.modelo.toSustancia
import data.modelo.toSustanciaEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SustanciaRepository @Inject constructor(
    private val sustanciaDao: SustanciaDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,) {
    fun getSustancias(): Flow<List<Sustancia>> {
        return flow {
            emit(sustanciaDao.getSustancias().map {it.toSustancia()})
        }.flowOn(dispatcher)
    }
    fun getSustanciaById(id:Int): Flow<Sustancia?> {
        return flow {
            emit(sustanciaDao.getSustanciaById(id).toSustancia())
        }.flowOn(dispatcher)
    }
    fun insertSustancia(sustancia: Sustancia) = flow { emit(sustanciaDao.insert(sustancia.toSustanciaEntity())) }.flowOn(dispatcher)

    fun updateSustancia(sustancia: Sustancia) = flow { emit(sustanciaDao.update(sustancia.toSustanciaEntity())) }.flowOn(dispatcher)

    fun deleteSustancia(sustancia: Sustancia) = flow { emit(sustanciaDao.delete(sustancia.toSustanciaEntity()))}.flowOn(dispatcher)
}