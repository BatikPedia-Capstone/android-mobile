package com.example.batikpedia.ui.listbatik

import androidx.lifecycle.ViewModel
import com.example.batikpedia.data.BatikRepository

class ListBatikViewModel(private val repository: BatikRepository): ViewModel() {

        fun getBatik() = repository.getBatikList()
}