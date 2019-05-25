package com.example.documentsreader.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.documentsreader.R
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.view.ViewCompat.isInLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener(this::onClickCreateFile)
    }

    private fun onClickCreateFile(v: View) {
        startActivity(Intent(this, CreateActivity::class.java))
    }

    fun onFragmentInteraction(fileName: String) {
        val fragment = fragmentManager
            .findFragmentById(R.id.textFragment) as ReadActivity
        if (fragment != null && fragment!!.isInLayout) {
            fragment!!.setText(fileName)
        }
    }

}
