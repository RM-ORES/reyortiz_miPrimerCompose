package data.modelo

import com.example.myapplication.domain.modelo.Sustancia

fun SustanciaEntity.toSustancia() : Sustancia{
    return Sustancia(this.id, this.descripcion, this.fecha, this.precio, this.legal, this.efecto, this.potencia, this.valoracion)
}
fun Sustancia.toSustanciaEntity() : SustanciaEntity{
    return SustanciaEntity(this.descripcion, this.fecha, this.precio, this.legal, this.efecto, this.potencia, this.valoracion, this.id)
}