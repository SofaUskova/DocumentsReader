package com.example.documentsreader.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.documentsreader.R
import java.text.SimpleDateFormat
import java.util.*

class DataAdapter(
    private val documents: List<String>,
    private val dateTime: Date,
    private val mOnSelectedItemListener: OnSelectedItemListener
) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataAdapter.ViewHolder, position: Int) {
        val formating = SimpleDateFormat("MM.dd HH:mm")
        val document = documents[position]
        holder.fileNameView.text = document
        holder.dateView.text = formating.format(dateTime).toString()

        holder.linearLayout.setOnClickListener { mOnSelectedItemListener.onSelectedItem(document) }
    }

    override fun getItemCount(): Int {
        return this.documents.size
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal val fileNameView: TextView = view.findViewById(R.id.fileName)
        internal val dateView: TextView = view.findViewById(R.id.date)
        internal val linearLayout: LinearLayout = view.findViewById(R.id.linear_layout)
    }

    interface OnSelectedItemListener {
        fun onSelectedItem(data: String)
    }
}