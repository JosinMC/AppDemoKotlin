package cr.ac.ucr.ecci.cql.appdemokotlin

import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cr.ac.ucr.ecci.cql.appdemokotlin.data.Ruta


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val ruta:Ruta = intent.getParcelableExtra(MainActivity.RUTA_TAG)

        // Se agrega el fragmento si no se habia hecho antes
        val details: DetailsFragment? = fragmentManager.findFragmentById(R.id.fragment_frame) as DetailsFragment?
        if (details == null) {

            // Se crea el fragmento detalle
            val detailsFragment = DetailsFragment.newInstance(ruta)

            // Inicia una transaccion para agregar el fragmento
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_frame, detailsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit()
        }
    }
}
