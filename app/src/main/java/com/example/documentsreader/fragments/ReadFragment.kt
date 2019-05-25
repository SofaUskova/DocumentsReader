package com.example.documentsreader.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.documentsreader.R
import com.example.documentsreader.utils.readFileText
import kotlinx.android.synthetic.main.read_activity.*
import android.widget.TextView

class ReadFragment : Fragment() {
//    private lateinit var view?: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
     //   view = inflater.inflate(R.layout.read_activity, container, false)
        return inflater.inflate(R.layout.read_activity, container, false)
    }

    fun setText(fileName: String) {
      //  val fileName = b.getString("POSITION")
        //val fileName = intent.extras.getString("result")
        readFileText(fileName, textView, view!!.context)
    }
}