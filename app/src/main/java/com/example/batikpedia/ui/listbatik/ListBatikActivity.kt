package com.example.batikpedia.ui.listbatik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikpedia.R
import com.example.batikpedia.ViewModelFactory
import com.example.batikpedia.data.ResultState
import com.example.batikpedia.databinding.ActivityListBatikBinding

class ListBatikActivity : AppCompatActivity() {

    private var binding: ActivityListBatikBinding? = null
    private val viewModel by viewModels<ListBatikViewModel> {
        ViewModelFactory.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBatikBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        val adapter = BatikAdapter()

        viewModel.getBatik().observe(this) { result ->
            if (result != null) {
                when (result) {
                    is ResultState.Loading -> {
                        binding?.progressBar?.visibility = android.view.View.VISIBLE
                    }

                    is ResultState.Success -> {
                        binding?.progressBar?.visibility = android.view.View.GONE
                        val batikData=result.data
                        adapter.submitList(batikData)

                    }

                    is ResultState.Error -> {
                        binding?.progressBar?.visibility = android.view.View.GONE
                    }
                }
            }
        }

        binding?.rvBatik?.apply {
            layoutManager = LinearLayoutManager(this@ListBatikActivity)
            setHasFixedSize(true)
            this.adapter = adapter
        }


    }
}