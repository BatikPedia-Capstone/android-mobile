package com.example.batikpedia.data

import com.example.batikpedia.data.response.BatikResponse
import com.example.batikpedia.data.response.BatikResponseItem
import retrofit2.Callback
import retrofit2.http.GET

interface BatikService {


    @GET("batik")
    suspend fun getBatik(): List<BatikResponseItem>


}