package cr.ac.ucr.ecci.cql.appdemokotlin.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.arch.persistence.db.SupportSQLiteDatabase



/**
 * Definicion de la base de datos usando la libreria Room.
 * En la anotacion @Database se definen las tablas que va a tener y la version.
 * Se maneja la instanciacion de forma singleton por eficiencia.
 */

@Database(entities = arrayOf(Ruta::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    // Operaciones en la base sobre la tabla ruta
    abstract fun rutaDao(): RutaDao

    // Objeto campanion, similar a static
    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "KotlinAppDatabase.db")
                        .addCallback(dataBaseCallback)
                        .allowMainThreadQueries() // Esto se deberia remover y consultar la base en el background
                        .build()

        // Callback llamado al crear la base
        var dataBaseCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                // Se insertan datos iniciales al crear la base
                UtilDataBase.insertInitialValuesBuses(db)
            }
        }

    }
}