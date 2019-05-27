package com.example.documentsreader.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.documentsreader.R
import com.example.documentsreader.utils.*
import kotlinx.android.synthetic.main.activity_read.*

class ReadFragment : Fragment() {
    private var fileNames: String = "Безымянный"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_read, container, false)
    }

    fun setText(fileName: String) {
        fileNames = fileName
        editText.setText("")
        readFileEditText(fileName, editText, view!!.context)
    }

    override fun onPause() {
        super.onPause()
        val fileNameWithoutNumber = if (fileNames.substring(fileNames.length - 5) == ").txt") {
            fileNames.dropLast(7)
        } else {
            fileNames.dropLast(4)
        }
        var newName = editText.text.toString().substringBefore("\n")
        if (!editText.text.isEmpty() && "$fileNameWithoutNumber.txt" != "$newName.txt") {
            if (isExists("$newName.txt"))
                newName = increaseDefaultValueOfFile(newName)
            renameFile(fileNames, newName, editText, view!!.context)
        }

        if ("$fileNameWithoutNumber.txt" == "$newName.txt") {
            saveFile(fileNameWithoutNumber, editText, view!!.context)
        }
    }
}