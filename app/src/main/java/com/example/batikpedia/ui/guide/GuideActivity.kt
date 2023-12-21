package com.example.batikpedia.ui.guide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batikpedia.R

class GuideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        supportActionBar?.setTitle("Guide")
    }
}