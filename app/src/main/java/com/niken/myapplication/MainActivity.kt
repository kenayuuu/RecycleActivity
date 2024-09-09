package com.niken.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.niken.myapplication.R
import com.niken.myapplication.adapter.BukuAdapter
import com.niken.myapplication.model.ModelBuku

class MainActivity : AppCompatActivity() {

    private lateinit var rv_data : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        rv_data = findViewById(R.id.rv_data)

        //kita bikin array data
        val listBuku = listOf(
            ModelBuku("Basis Data", "Niken"),
            ModelBuku(judul = "Multimedia", penerbit = "Niken"),
            ModelBuku("Pemrograman Mobile", "Niken"),
            ModelBuku("PBO", "Fanny"),
            ModelBuku("Algoritma", "Defni")
            )
        val nBukuAdapter = BukuAdapter(listBuku)
        rv_data.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = nBukuAdapter
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}