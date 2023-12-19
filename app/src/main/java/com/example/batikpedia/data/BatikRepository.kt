package com.example.batikpedia.data

import android.util.Log
import androidx.lifecycle.liveData
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.File

class BatikRepository(private val apiService:ApiService, private val batikService: BatikService) {

    fun detectionImage(imageFile: File) = liveData {
        emit(ResultState.Loading)
        val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
        val multipartBody = MultipartBody.Part.createFormData(
            "file",
            imageFile.name,
            requestImageFile
        )
        try {
            val successResponse = apiService.uploadDetection(multipartBody)
            emit(ResultState.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            emit(ResultState.Error(errorBody.toString()) )
        }

    }

    fun getBatikList() = liveData {
        emit(ResultState.Loading)
        try {
            val successResponse = batikService.getBatik()
            emit(ResultState.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            emit(ResultState.Error(errorBody.toString()) )
        }

    }


    companion object {
        @Volatile
        private var instance: BatikRepository? = null
        fun getInstance(apiService: ApiService,batikService: BatikService) =
            instance ?: synchronized(this) {
                instance ?: BatikRepository(apiService,batikService)
            }.also { instance = it }
    }
}