package com.example.documentsreader.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.documentsreader.R
import com.example.documentsreader.fragments.ContentFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.example.documentsreader.fragments.ReadFragment

class MainActivity : AppCompatActivity(), ContentFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener(this::onClickCreateFile)
    }

    private fun onClickCreateFile(v: View) {
        startActivity(Intent(this, CreateActivity::class.java))
    }

    override fun onFragmentInteraction(link: String) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.textFragment) as ReadFragment
        if (fragment.isInLayout) {
            fragment.setText(link)
        }
    }
}
