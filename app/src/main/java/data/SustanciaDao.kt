package data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import data.modelo.SustanciaEntity

@Dao
interface SustanciaDao {
    @Query("SELECT * from sustancias")
    suspend fun getSustancias(): List<SustanciaEntity>

    @Query("SELECT * from sustancias where sustancias.id = :id")
    suspend fun getSustanciaById(id: Int): SustanciaEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: SustanciaEntity) : Long

    @Update
    fun update(item: SustanciaEntity)

    @Delete
    fun delete(item: SustanciaEntity)
}