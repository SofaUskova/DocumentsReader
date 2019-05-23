package com.example.documentsreader.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.documentsreader.R
import com.example.documentsreader.utils.readFileEditText
import com.example.documentsreader.utils.saveFile
import kotlinx.android.synthetic.main.create_activity.*

class CreateActivity : AppCompatActivity() {
    private var context: Context = this
    private var FILENAME: String = "Безымянный"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_activity)

        val fileName: String?
        if (intent.extras != null) {
            fileName = intent.extras.getString("POSITION")
            readFileEditText(fileName, editText, this)
        }
    }

    override fun onPause() {
        super.onPause()
        if (!editText.text.toString().isEmpty()) {
            FILENAME = editText.text.toString().substringBefore("\n")
        }

        saveFile("$FILENAME.txt", editText, context)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(
            Intent(this, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        )
    }
}