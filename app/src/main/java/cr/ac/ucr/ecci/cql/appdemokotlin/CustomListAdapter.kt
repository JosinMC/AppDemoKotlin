package cr.ac.ucr.ecci.cql.appdemokotlin

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cr.ac.ucr.ecci.cql.appdemokotlin.data.Ruta
import kotlinx.android.synthetic.main.custom_list_layout.view.*

/**
 * Adaptador para mostrar una lista personalizada con una imagen y una etiqueta.
 */

class CustomListAdapter(private val context: Activity, private val mRutas: List<Ruta>) : BaseAdapter() {

    override fun getCount(): Int {
        return mRutas.size
    }

    override fun getItem(position: Int): Any {
        return mRutas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Importante cambiar en la firma "view: View" a "view: View?" para permitir que llegue nulo
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        val mLayoutInflater = context.layoutInflater

        val mView = mLayoutInflater.inflate(R.layout.custom_list_layout, null)
        // Se puede acceder a los View sin tener que usar findViewById gracias a synthetic
        val mTextViewName = mView.custom_list_name
        mTextViewName.text = mRutas[position].nombre

        val mImageView = mView.custom_list_image
        mImageView.setImageResource(R.drawable.bus_side)

        return mView
    }

}