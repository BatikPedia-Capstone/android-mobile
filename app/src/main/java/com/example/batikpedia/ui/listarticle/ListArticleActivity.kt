package com.example.batikpedia.ui.listarticle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batikpedia.R

class ListArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_article)

        supportActionBar?.setTitle("List Article")
    }
}