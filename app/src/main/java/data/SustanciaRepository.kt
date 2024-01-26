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
    suspend fun getSustancias(): Flow<List<Sustancia>> {
        return flow {
            emit(sustanciaDao.getSustancias().map {it.toSustancia()})
        }.flowOn(dispatcher)
    }
    suspend fun getSustanciaById(id:Int): Flow<Sustancia?> {
        return flow{
            emit(sustanciaDao.getSustanciaById(id).toSustancia())
        }.flowOn(dispatcher)
    }
    suspend fun insertSustancia(sustancia: Sustancia) = sustanciaDao.insert(sustancia.toSustanciaEntity())
    suspend fun updateSustancia(sustancia: Sustancia) = sustanciaDao.update(sustancia.toSustanciaEntity())
    suspend fun deleteSustancia(sustancia: Sustancia) = sustanciaDao.delete(sustancia.toSustanciaEntity())
}