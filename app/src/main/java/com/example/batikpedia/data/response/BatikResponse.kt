package com.example.batikpedia.data.response

import com.google.gson.annotations.SerializedName

data class BatikResponse(

	@field:SerializedName("BatikResponse")
	val batikResponse: List<BatikResponseItem>
)

data class BatikResponseItem(

	@field:SerializedName("asal")
	val asal: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("url_gambar")
	val urlGambar: String,

	@field:SerializedName("sejarah")
	val sejarah: String,

	@field:SerializedName("id")
	val id: String
)
