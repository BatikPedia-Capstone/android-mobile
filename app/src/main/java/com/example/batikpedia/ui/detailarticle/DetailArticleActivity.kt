package com.example.batikpedia.ui.detailarticle

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batikpedia.R
import com.example.batikpedia.data.response.ArticleResponseItem
import com.example.batikpedia.databinding.ActivityDetailArticleBinding

class DetailArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val article = intent.getParcelableExtra<ArticleResponseItem>(EXTRA_ARTICLE) as ArticleResponseItem

        binding.tvItemTitle.text = article.judul
        binding.tvItemIsiArticle.text = article.isi
        binding.btnUrl.setOnClickListener {
            val url = article.urlArtikel
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

    companion object {
        const val EXTRA_ARTICLE: String = "extra_article"
    }
}