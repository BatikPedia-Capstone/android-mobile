package com.example.batikpedia.di

import com.example.batikpedia.data.ApiConfig
import com.example.batikpedia.data.BatikRepository

object Injection {
    fun provideRepository(): BatikRepository {
        val apiService = ApiConfig.getApiService()
        val batikService = ApiConfig.getBatikService()
        return BatikRepository.getInstance(apiService, batikService)
    }
}