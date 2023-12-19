package com.example.batikpedia.ui.detailbatik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batikpedia.R
import com.example.batikpedia.databinding.ActivityDetailBatikBinding

class DetailBatikActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBatikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBatikBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}