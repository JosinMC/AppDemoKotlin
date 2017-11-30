package cr.ac.ucr.ecci.cql.appdemokotlin.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Entidad que representa una ruta de un bus de la UCR.
 * Se usa la anotacion @Parcelize que automaticamente genera los metodos para serializar la clase.
 * Se usan las anotaciones de la libreria Room para usar esta entidad como una tabla de la base de datos.
 * El keyword data permite que se implementen metodos como tipicos de clases de datos como toString, equals o copy.
 */

@Parcelize
@Entity
data class Ruta(
        @PrimaryKey
        var identificacion: String,
        var nombre: String,
        var tarifa: Int,
        var pasajerosUnidad: Int,
        var paradaLatitudUCR: Double,
        var paradaLongitudUCR: Double,
        var paradaLatitudSalida: Double,
        var paradaLongitudSalida: Double,
        var cantidadBuses: Int) : Parcelable