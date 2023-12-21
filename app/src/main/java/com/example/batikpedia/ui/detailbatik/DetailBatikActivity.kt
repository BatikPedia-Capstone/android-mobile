package com.example.batikpedia.ui.detailbatik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.batikpedia.R
import com.example.batikpedia.data.response.BatikResponseItem
import com.example.batikpedia.databinding.ActivityDetailBatikBinding

class DetailBatikActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBatikBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBatikBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val batik = intent.getParcelableExtra<BatikResponseItem>(EXTRA_DATA) as BatikResponseItem
        binding.tvItemTitle.text = batik.namaBatik
        binding.tvItemAsal.text = batik.asalBatik
        binding.tvItemMakna.text = batik.maknaBatik
        Glide.with(this)
            .load(batik.urlGambar)
            .into(binding.imgBatik)




    }

    companion object {
        const val EXTRA_DATA: String = "extra_data"
    }
}