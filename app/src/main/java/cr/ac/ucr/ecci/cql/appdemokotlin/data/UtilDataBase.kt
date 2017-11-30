package cr.ac.ucr.ecci.cql.appdemokotlin.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.OnConflictStrategy
import android.content.ContentValues

/**
 * Objeto para insercion inicial de datos.
 * Se usa objeto en vez de clase para evitar que se instancie, lo que da un resultado similar
 * a static en Java.
 */

object UtilDataBase {

    // Se realizan las inserciones de los datos de los buses externos (Rutas)
    fun insertInitialValuesBuses(db: SupportSQLiteDatabase) {

        // Datos de las Rutas
        val arrayRutas = arrayOf(
                arrayOf("1", "Acosta", "1120", "47", "9.935565", " -84.050026", "9.9279679", "-84.084316", "1"), 
                arrayOf("2", "Alajuela", "780", "59", "9.935541", "-84.050181", "10.0148947", "-84.2170701", "12"), 
                arrayOf("3", "Alajuelita", "460", "49", "9.934136", "-84.052175", "9.902502", "-84.099912", "2"), 
                arrayOf("4", "Calle Blancos", "360", "48", "9.934608", " -84.051962", "9.9508241", "-84.0596262", "1"), 
                arrayOf("5", "Cartago", "550", "50", "9.935521", "-84.050240", "9.858296", "-83.9224708", "5"), 
                arrayOf("6", "Coronado", "550", "54", "9.935235", "-84.050780", "9.9780093", "-84.0069361", "5"), 
                arrayOf("7", "Desamparados - Aserrí", "475", "58", "9.935227", "-84.051219", "9.888622", "-84.064813", "3"), 
                arrayOf("8", "Grecia", "1320", "55", "9.935244", "-84.051079", "10.072463", "-84.311673", "2"), 
                arrayOf("9", "Heredia", "510", "56", "9.935470", "-84.049528", "9.9972811", "-84.1185905", "7"), 
                arrayOf("10", "Pavas", "510", "47", "9.934815", "-84.051812", "9.947369", "-84.136270", "3"), 
                arrayOf("11", "San Carlos", "1785", "59", "9.935395", "-84.049157", "10.3289884", "-84.4389415", "1"), 
                arrayOf("12", "San Rafael Abajo - San Juan de Dios Desamparados", "0", "47", "9.934912", "-84.051665", "9.879160", "-84.082839", "2"), 
                arrayOf("13", "San Ramón", "1650", "56", "9.935429", "-84.049301", "10.088871", "-84.471953", "2"), 
                arrayOf("14", "Tibás", "420", "52", "9.935416", "-84.050167", "9.953285", "-84.0556343", "4"), 
                arrayOf("15", "Santa Ana Escazú", "630", "53", "9.934050", "-84.052206", "9.9358617", "-84.2222384", "3"), 
                arrayOf("16", "El Carmen de Guadalupe", "395", "43", "9.935323", "-84.050481", "9.9590744", "-83.9986701", "1")
        )

        // Inserción de las rutas
        for (arrayRuta in arrayRutas) {

            val values = ContentValues()
            values.put(Ruta::identificacion.name, arrayRuta[0])
            values.put(Ruta::nombre.name, arrayRuta[1])
            values.put(Ruta::tarifa.name, Integer.parseInt(arrayRuta[2]))
            values.put(Ruta::pasajerosUnidad.name, Integer.parseInt(arrayRuta[3]))
            values.put(Ruta::paradaLatitudUCR.name, java.lang.Double.parseDouble(arrayRuta[4]))
            values.put(Ruta::paradaLongitudUCR.name, java.lang.Double.parseDouble(arrayRuta[5]))
            values.put(Ruta::paradaLatitudSalida.name, java.lang.Double.parseDouble(arrayRuta[6]))
            values.put(Ruta::paradaLongitudSalida.name, java.lang.Double.parseDouble(arrayRuta[7]))
            values.put(Ruta::cantidadBuses.name, Integer.parseInt(arrayRuta[8]))

            db.insert(Ruta::class.java.simpleName, OnConflictStrategy.IGNORE, values)
        }
    }
}