package com.example.documentsreader.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.documentsreader.R
import com.example.documentsreader.adapters.DataAdapter
import com.example.documentsreader.fragments.ContentFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.example.documentsreader.fragments.ReadFragment
import com.example.documentsreader.utils.getFileList
import kotlinx.android.synthetic.main.activity_content.*
import java.util.*

class MainActivity : AppCompatActivity(), ContentFragment.OnFragmentInteractionListener, DataAdapter.OnSelectedItemListener {
    val PATH = "data//com.example.documentsreader//files"
    //private var mOnFragmentInteractionListener: ContentFragment.OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            val documents: List<String> = getFileList(PATH)

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = DataAdapter(documents, Date(), this)
        }

        fab.setOnClickListener(this::onClickCreateFile)
    }

    override fun onSelectedItem(data: String) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val mediaStreamIntent = Intent(this, ReadActivity::class.java)
        mediaStreamIntent.putExtra("POSITION", data)
        this.startActivity(mediaStreamIntent)
        //onFragmentInteraction(data)
    }

    private fun onClickCreateFile(v: View) {
        startActivity(Intent(this, CreateActivity::class.java))
    }

    override fun onFragmentInteraction(link: String) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.textFragment) as ReadFragment
        if (fragment.isInLayout) {
            fragment.setText(link)
        } else {
            val mediaStreamIntent = Intent(this, ReadActivity::class.java)
            mediaStreamIntent.putExtra("POSITION", link)
            this.startActivity(mediaStreamIntent)
        }
    }
}
