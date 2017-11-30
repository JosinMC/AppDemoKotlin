package cr.ac.ucr.ecci.cql.appdemokotlin.data

import android.arch.persistence.room.*


/**
 * Interfaz que describe las operaciones a realizar sobre la tabla Ruta en la base de datos.
 */
@Dao
interface RutaDao {
    @get:Query("SELECT * FROM Ruta")
    val all: List<Ruta>

    @Insert
    fun insert(ruta: Ruta)

    @Update
    fun update(ruta: Ruta)

    @Delete
    fun delete(ruta: Ruta)
}
