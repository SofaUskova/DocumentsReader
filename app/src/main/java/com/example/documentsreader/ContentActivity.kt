package com.example.documentsreader

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.documentsreader.adapters.DataAdapter
import com.example.documentsreader.utils.getFileList
import java.util.*

class ContentActivity : Fragment() {
    private val PATH = "data//com.example.documentsreader//files"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val documents: List<String> = getFileList(PATH)

        val view = inflater.inflate(R.layout.content_main, container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val context = view.context

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = DataAdapter(documents, Date(), context)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mListener = context as OnFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context должен реализовывать интерфейс OnFragmentInteractionListener")
        }
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(link: String)
    }
}