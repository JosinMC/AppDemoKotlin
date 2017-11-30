package cr.ac.ucr.ecci.cql.appdemokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import cr.ac.ucr.ecci.cql.appdemokotlin.data.AppDatabase
import cr.ac.ucr.ecci.cql.appdemokotlin.data.Ruta

import kotlinx.android.synthetic.main.activity_main.*

/**
 * Actividad principal que muestra una lista personalizada de rutas de buses de la UCR.
 */
class MainActivity : AppCompatActivity() {

    companion object {
        val RUTA_TAG = "objeto_ruta"
    }

    private lateinit var mRutas: List<Ruta>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Se llena el objeto mRutas con datos
        getData()
        // Se llena la lista con los datos obtenidos de la base y usando el adaptor custom
        main_listview.adapter = CustomListAdapter(this, mRutas)
        // Se establece el listener para cuando tocan un item de la lista
        main_listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, index, l ->
            // Se obtiene el indice del item al que se le hizo clic, con esto se indiza en la lista de objetos
            startFragment(mRutas[index])
        }

    }

    private fun getData(){
        // Se obtiene la instancia de la base de datos
        val database = AppDatabase.getInstance(this)
        // Se traen todas las rutas de la base
        mRutas = database.rutaDao().all
    }

    private fun startFragment(ruta: Ruta){
        val intent = Intent(this, DetailsActivity::class.java)
        // El objeto se puede pasar entre actividades porque implementa Parcelable
        intent.putExtra(RUTA_TAG,ruta)
        startActivity(intent)
    }
}
