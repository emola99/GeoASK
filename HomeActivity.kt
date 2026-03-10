package com.example.geoankieta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val listBtn : Button = findViewById(R.id.list_button)
        listBtn.setOnClickListener{val intent= Intent(this@HomeActivity,
            ListActivity::class.java)
            startActivity(intent)

        }
    }
}

