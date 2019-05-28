package com.example.documentsreader.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.documentsreader.R
import com.example.documentsreader.utils.increaseDefaultValueOfFile
import com.example.documentsreader.utils.isExists
import com.example.documentsreader.utils.saveFile
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {
    private var context: Context = this
    private var FILENAME: String = "Безымянный"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
    }

    override fun onPause() {
        super.onPause()
        if (!editTextCreate.text.isEmpty()) {
            FILENAME = editTextCreate.text.toString().substringBefore("\n")
            if (isExists("$FILENAME.txt"))
                FILENAME = increaseDefaultValueOfFile(FILENAME)
        } else {
            if (isExists("$FILENAME.txt"))
                FILENAME = increaseDefaultValueOfFile(FILENAME)
        }

        saveFile(FILENAME, editTextCreate, context)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(
            Intent(this, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        )
    }
}