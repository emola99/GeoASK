package com.example.geoankieta

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val arrayAdapter: ArrayAdapter<*>

        val polls = arrayOf("Kampus Politechniki Warszawskiej")
        val mListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, polls)
        mListView.adapter = arrayAdapter
        mListView.setOnItemClickListener {parent: AdapterView<*>, view, position, id -> if (position ==0)
        {
           startActivity(Intent(this,DescriptionActivity::class.java))
        }
     }
    }
}