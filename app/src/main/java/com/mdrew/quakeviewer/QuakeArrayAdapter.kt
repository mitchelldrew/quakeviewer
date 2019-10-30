package com.mdrew.quakeviewer

import android.content.Context
import android.content.res.Resources
import android.widget.ArrayAdapter
import com.mdrew.quakeviewer.model.Quake
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class QuakeArrayAdapter(val quakes:MutableList<Quake>, context: Context): ArrayAdapter<Quake>(context, 0, quakes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val quake = quakes[position]
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = convertView ?: inflater.inflate(R.layout.quake_list_item, parent, false)
        val magnitudeView:TextView = rowView.findViewById(R.id.magnitude)
        val firstLine:TextView = rowView.findViewById(R.id.firstLine)
        val secondLine:TextView = rowView.findViewById(R.id.secondLine)
        magnitudeView.text = "${quake.magnitude}"
        firstLine.text = quake.datetime
        secondLine.text = quake.src
            if(quake.magnitude >= 8.0){
                magnitudeView.setTextColor(context.resources.getColor(R.color.red))
            } else {
                magnitudeView.setTextColor(context.resources.getColor(R.color.black))
            }

        return rowView
    }

}