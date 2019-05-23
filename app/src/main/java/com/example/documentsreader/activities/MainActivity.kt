package com.example.documentsreader.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.documentsreader.R
import com.example.documentsreader.adapters.DataAdapter
import com.example.documentsreader.utils.getFileList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val PATH = "data//com.example.documentsreader//files"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val documents: List<String> = getFileList(PATH)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DataAdapter(documents, Date(), this)

        fab.setOnClickListener(this::onClickCreateFile)
    }

    private fun onClickCreateFile(v: View) {
        startActivity(Intent(this, CreateActivity::class.java))
    }
}
