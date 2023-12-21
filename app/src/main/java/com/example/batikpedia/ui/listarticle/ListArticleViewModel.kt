package com.example.batikpedia.ui.listarticle

import androidx.lifecycle.ViewModel
import com.example.batikpedia.data.BatikRepository

class ListArticleViewModel(private val repository: BatikRepository): ViewModel() {

        fun getArticle() = repository.getArticleList()
}