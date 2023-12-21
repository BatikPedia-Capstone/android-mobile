package com.example.batikpedia.ui.detection

import androidx.lifecycle.ViewModel
import com.example.batikpedia.data.BatikRepository
import java.io.File

class DetectionViewModel(private val repository: BatikRepository): ViewModel()  {

    fun detectionImage(file: File) = repository.detectionImage(file)

    fun getBatikDetail(batikName: String) = repository.getBatikDetail(batikName)
}
