package cr.ac.ucr.ecci.cql.appdemokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.*
import cr.ac.ucr.ecci.cql.appdemokotlin.data.Ruta
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var mRuta: Ruta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Se obtiene el objeto ruta pasado por parametro
        mRuta = intent.getParcelableExtra(MainActivity.RUTA_TAG)
        // Se obtiene el mapa de forma asincrona y se recibe en el callback onMapReady
        val mapFragment = google_map as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Callback que se llama cuando el mapa esta inicializado.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val paradaUCR    = LatLng(mRuta.paradaLatitudUCR, mRuta.paradaLongitudUCR)
        val paradaSalida = LatLng(mRuta.paradaLatitudSalida, mRuta.paradaLongitudSalida)
        putMarker(paradaSalida, R.drawable.bus_stop)
        putMarker(paradaUCR, R.drawable.bus_stop_ucr)
        // Centra la camara en la UCR
        moveCamera(LatLng(9.934680, -84.051373), 10.toFloat())
        mMap.uiSettings.setAllGesturesEnabled(true)
    }

    fun putMarker(latlon: LatLng, icon: Int){
        val marker = mMap.addMarker(MarkerOptions().position(latlon).title(mRuta.nombre))
        marker.setIcon(BitmapDescriptorFactory.fromResource(icon))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlon))
    }

    fun goToStop(view: View){
        moveCamera(LatLng(mRuta.paradaLatitudSalida,mRuta.paradaLongitudSalida),14.toFloat())
    }

    fun goToStopUCR(view: View){
        moveCamera(LatLng(mRuta.paradaLatitudUCR,mRuta.paradaLongitudUCR),14.toFloat())
    }

    fun moveCamera(latlon: LatLng, zoom: Float){
        // Centra el mapa en la coordenada
        val cameraPosition = CameraPosition.Builder()
                .target(latlon)
                .zoom(zoom)
                .build()
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }
}
