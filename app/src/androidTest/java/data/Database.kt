package data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import data.modelo.SustanciaEntity

@Database(entities = [SustanciaEntity::class], version = 6, exportSchema = true)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract fun sustanciaDao(): SustanciaDao

    companion object{
        @Volatile
        private var INSTANCE: data.Database? = null

        fun getDatabase(context: Context): data.Database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    data.Database::class.java,
                    "item_database")
                    .createFromAsset("database/personas.db")
                    .fallbackToDestructiveMigrationFrom(4)
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}