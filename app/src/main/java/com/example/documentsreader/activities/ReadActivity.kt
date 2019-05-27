package com.example.documentsreader.activities

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.documentsreader.R
import com.example.documentsreader.utils.*
import kotlinx.android.synthetic.main.activity_read.*

class ReadActivity : AppCompatActivity() {
    private var context: Context = this
    private var fileName: String = "Безымянный"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }
        setContentView(R.layout.activity_read)

        if (intent.extras != null) {
            fileName = intent.extras.getString("POSITION")
            readFileEditText(fileName, editText, this)
        }
    }

    override fun onPause() {
        super.onPause()
        val fileNameWithoutNumber = if (fileName.substring(fileName.length - 5) == ").txt") {
            fileName.dropLast(7)
        } else {
            fileName.dropLast(4)
        }
        var newName = editText.text.toString().substringBefore("\n")
        if (!editText.text.isEmpty() && "$fileNameWithoutNumber.txt" != "$newName.txt") {
            if (isExists("$newName.txt"))
                newName = increaseDefaultValueOfFile(newName)
            renameFile(fileName, newName, editText, context)
        }

        if ("$fileNameWithoutNumber.txt" == "$newName.txt") {
            saveFile(fileNameWithoutNumber, editText, context)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(
            Intent(this, MainActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        )
    }
}