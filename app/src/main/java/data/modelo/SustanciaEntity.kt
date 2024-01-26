package data.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "sustancias"
)
data class SustanciaEntity(
    var descripcion: String = "",
    var fecha: LocalDate? = null,
    var precio: Int? = null,
    var legal: Boolean? = null,
    var efecto: String? = null,
    var potencia: Int? = null,
    var valoracion: Int? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
)
