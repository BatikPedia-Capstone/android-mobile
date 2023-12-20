package com.example.batikpedia.data.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse(

	@field:SerializedName("ArticleResponse")
	val articleResponse: List<ArticleResponseItem>
)

data class ArticleResponseItem(

	@field:SerializedName("nama_batik")
	val namaBatik: String,

	@field:SerializedName("id_artikel")
	val idArtikel: Int,

	@field:SerializedName("judul")
	val judul: String,

	@field:SerializedName("url_artikel")
	val urlArtikel: String,

	@field:SerializedName("isi")
	val isi: String
)
