package com.example.documentsreader.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.documentsreader.R
import com.example.documentsreader.utils.readFileText
import kotlinx.android.synthetic.main.read_activity.*

class ReadFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.read_activity, container, false)
    }

    fun setText(fileName: String) {
        textView.text = ""
        readFileText(fileName, textView, view!!.context)
    }
}