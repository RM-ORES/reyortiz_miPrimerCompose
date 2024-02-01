package data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import data.modelo.SustanciaEntity
import utils.Constantes

@Dao
interface SustanciaDao {
    @Query(Constantes.SELECT_ALL)
    suspend fun getSustancias(): List<SustanciaEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: SustanciaEntity)

    @Update
    fun update(item: SustanciaEntity)

    @Delete
    fun delete(item: SustanciaEntity)
}