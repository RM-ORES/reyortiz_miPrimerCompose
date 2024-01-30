package utils

object Constantes {
    //error
    const val ERROR = "Ha habido un error"

    //info
    const val ANADIDO = "Sustancia añadida"
    const val BORRADO = "Sustancia borrada"
    const val MODIFICADO = "Sustancia modificada"

    //efectos
    const val ESTIMULANTE = "Estimulante"
    const val DISOCIATIVO = "Disociativo"
    const val PSICODELICO = "Psicodélico"

    //Sustancias
    const val SUSNOMBRE1 = "MDMA, cerberus rosa"
    const val SUSNOMBRE2 = "6-APB, cápsulas"
    const val SUSNOMBRE3 = "LSD, cartón 200"
    const val SUSNOMBRE4 = "Cloretilo, spray"
    const val SUSNOMBRE5 = "Speed"
    const val SUSNOMBRE6 = "Setas Wollongong"
    const val SUSNOMBRE7 = "Popper marca Amyl"

    const val SUSTANCIAS = "sustancias"
    const val ITEM_DATABASE ="item_database"
    const val DATABASE_PATH = "database/sustancias.db"
    const val APP_DB = "app.db"
    const val SELECT_BY_ID ="SELECT * from sustancias where sustancias.id = :id"
    const val SELECT_ALL = "SELECT * from sustancias"
}