package com.example.batikpedia.data

import com.example.batikpedia.data.response.DetectionResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @Multipart
    @POST("/")
    suspend fun uploadDetection(
        @Part file: MultipartBody.Part,
    ):DetectionResponse

}