package com.example.batikpedia.data

import com.example.batikpedia.data.response.ArticleResponseItem
import com.example.batikpedia.data.response.BatikResponse
import com.example.batikpedia.data.response.BatikResponseItem
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path

interface BatikService {


    @GET("batik")
    suspend fun getBatik(): List<BatikResponseItem>

    @GET("articles")
    suspend fun getArticle(): List<ArticleResponseItem>

    @GET("batik/{batik_name}")
    suspend fun getBatikDetail(
        @Path("batik_name") batikName: String
    ): BatikResponseItem


}