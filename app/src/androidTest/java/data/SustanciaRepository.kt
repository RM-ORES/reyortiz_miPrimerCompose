package data

import com.example.myapplication.domain.modelo.Sustancia
import data.modelo.toSustancia
import data.modelo.toSustanciaEntity
import javax.inject.Inject

class SustanciaRepository @Inject constructor(private val sustanciaDao: SustanciaDao) {
    suspend fun getSustancias() = sustanciaDao.getSustancias().map {it.toSustancia()}
    suspend fun getSustanciaById(id:Int) = sustanciaDao.getSustanciaById(id).toSustancia()
    suspend fun insertSustancia(sustancia: Sustancia) = sustanciaDao.insert(sustancia.toSustanciaEntity())
    suspend fun updateSustancia(sustancia: Sustancia) = sustanciaDao.update(sustancia.toSustanciaEntity())
    suspend fun deleteSustancia(sustancia: Sustancia) = sustanciaDao.delete(sustancia.toSustanciaEntity())
}