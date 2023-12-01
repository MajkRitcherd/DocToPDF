package com.doctopdf.helpers

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.doctopdf.R
import java.io.File

/**
 * Custom array adapter to fetch list view.
 */
class CustomArrayAdapter (private val context: Activity, private val layoutId: Int, private val files: ArrayList<File>)
    : ArrayAdapter<File>(context, layoutId, files) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = context.layoutInflater
        val rowView: View = inflater.inflate(layoutId, null, true)
        val fileNameText = rowView.findViewById<View>(R.id.text_filename) as TextView
        val fileSizeText = rowView.findViewById<View>(R.id.text_file_size) as TextView
        val lastUpdateText = rowView.findViewById<View>(R.id.text_last_update) as TextView

        val file = FileItem(files[position])
        fileNameText.text = file.name
        fileSizeText.text = file.sizeText
        lastUpdateText.text = file.lastModifiedText
        return rowView
    }
}