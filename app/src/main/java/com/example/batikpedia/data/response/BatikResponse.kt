package com.example.batikpedia.data.response

import com.google.gson.annotations.SerializedName

data class BatikResponse(

    @field:SerializedName("BatikResponse")
    val batikResponse: List<BatikResponseItem>
)

data class BatikResponseItem(

    @field:SerializedName("asal_batik")
    val asalBatik: String,

    @field:SerializedName("url_gambar")
    val urlGambar: String,

    @field:SerializedName("nama_batik")
    val namaBatik: String,

    @field:SerializedName("makna_batik")
    val maknaBatik: String,

    @field:SerializedName("id_batik")
    val idBatik: Int
)
