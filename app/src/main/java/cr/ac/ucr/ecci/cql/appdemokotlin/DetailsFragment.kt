package cr.ac.ucr.ecci.cql.appdemokotlin

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cr.ac.ucr.ecci.cql.appdemokotlin.data.Ruta
import kotlinx.android.synthetic.main.fragment_details.view.*


/**
 * Fragmento que muestra el detalle de un objeto ruta pasado por parametro.
 */
class DetailsFragment : Fragment() {

    lateinit var mRuta: Ruta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mRuta = arguments.getParcelable(MainActivity.RUTA_TAG)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // El operador !! indica que inflater puede lanzar NPE
        val view = inflater!!.inflate(R.layout.fragment_details, container, false)

        view.details_text.text = getDetails()
        // Se puede simplificar mucho la creacion de clases anonimas para los onClickListeners usando lambdas.
        view.maps_button.setOnClickListener {openMap()}
        return view
    }

    fun openMap(){
        val intent = Intent(activity, MapsActivity::class.java)
        // El objeto se puede pasar entre actividades porque implementa Parcelable
        intent.putExtra(MainActivity.RUTA_TAG, mRuta)
        startActivity(intent)
    }

    fun getDetails(): String{
        return "Nombre: ${mRuta.nombre}\n" +
                "Tarifa: ${mRuta.tarifa}\n" +
                "Pasajeros por unidad: ${mRuta.pasajerosUnidad}\n" +
                "Cantidad de buses: ${mRuta.cantidadBuses}\n"
    }

    companion object {
        /**
         * Crea una nueva instancia del fragmento
         */
        fun newInstance(ruta: Ruta): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            args.putParcelable(MainActivity.RUTA_TAG, ruta)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
