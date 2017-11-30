package cr.ac.ucr.ecci.cql.appdemokotlin

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

        view.details_text.text = mRuta.toString()

        return view
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
