package com.example.batikpedia.ui.listarticle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikpedia.data.response.ArticleResponseItem
import com.example.batikpedia.data.response.BatikResponseItem
import com.example.batikpedia.databinding.ItemArticleBinding
import com.example.batikpedia.databinding.ItemBatikBinding
import com.example.batikpedia.ui.listarticle.ArticleAdapter.ArticleViewHolder.Companion.DIFF_CALLBACK
import com.example.batikpedia.ui.listbatik.BatikAdapter

class ArticleAdapter:ListAdapter<ArticleResponseItem, ArticleAdapter.ArticleViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding=ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArticleAdapter.ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article=getItem(position)
        if (article != null) {
            holder.bind(article)
        }
    }
    class ArticleViewHolder (private val binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticleResponseItem) {
            binding.tvItemTitle.text = article.judul
            binding.tvItemIsiArtikel.text = article.namaBatik

        }

        companion object {
            val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticleResponseItem>() {
                override fun areItemsTheSame(
                    oldItem: ArticleResponseItem,
                    newItem: ArticleResponseItem
                ): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(
                    oldItem: ArticleResponseItem,
                    newItem: ArticleResponseItem
                ): Boolean {
                    return oldItem == newItem
                }

            }
        }
    }
}
