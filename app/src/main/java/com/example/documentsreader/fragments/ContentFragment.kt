package com.example.documentsreader.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.documentsreader.R
import com.example.documentsreader.adapters.DataAdapter
import com.example.documentsreader.utils.getFileList
import java.util.*

class ContentFragment : Fragment(), DataAdapter.OnSelectedItemListener {
    private val PATH = "data//com.example.documentsreader//files"
    private var mOnFragmentInteractionListener: OnFragmentInteractionListener? = null

    override fun onSelectedItem(data: String) {
        // передача данных активити
        mOnFragmentInteractionListener?.onFragmentInteraction(data)
        //todo здесь можешь передать данные в активити или обработать во фрагменте в зависимости от ситуации
        // активити что содержит фрагмент должен реализовывать интерфейс OnFragmentInteractionListener по аналогии
        // как этот фрагмент реализует интерфейс слушателя для адаптера
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val documents: List<String> = getFileList(PATH)

        val view = inflater.inflate(R.layout.content_main, container, false)
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        val context = view.context

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = DataAdapter(documents, Date(), this)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mOnFragmentInteractionListener = context as OnFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context должен реализовывать интерфейс OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        mOnFragmentInteractionListener = null
        super.onDetach()
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(link: String)
    }
}