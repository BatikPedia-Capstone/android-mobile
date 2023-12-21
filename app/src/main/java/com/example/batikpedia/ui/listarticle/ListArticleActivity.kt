package com.example.batikpedia.ui.listarticle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikpedia.R
import com.example.batikpedia.ViewModelFactory
import com.example.batikpedia.databinding.ActivityListArticleBinding

class ListArticleActivity : AppCompatActivity() {

    private var binding: ActivityListArticleBinding? = null

    val viewModel by viewModels<ListArticleViewModel> {
        ViewModelFactory.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListArticleBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.hide()

        viewModel.getArticle().observe(this) { result ->
            if (result != null) {
                when (result) {
                    is com.example.batikpedia.data.ResultState.Loading -> {
                        binding?.progressBar?.visibility = android.view.View.VISIBLE
                    }

                    is com.example.batikpedia.data.ResultState.Success -> {
                        binding?.progressBar?.visibility = android.view.View.GONE
                        val articleData=result.data
                        val adapter = ArticleAdapter()
                        adapter.submitList(articleData)
                        binding?.rvArticle?.adapter=adapter

                    }

                    is com.example.batikpedia.data.ResultState.Error -> {
                        binding?.progressBar?.visibility = android.view.View.GONE
                    }
                }
            }
        }

        binding?.rvArticle?.apply {
            layoutManager = LinearLayoutManager(this@ListArticleActivity)
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }
}