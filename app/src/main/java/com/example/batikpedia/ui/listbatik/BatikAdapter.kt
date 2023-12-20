package com.example.batikpedia.ui.listbatik

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikpedia.data.response.BatikResponseItem
import com.example.batikpedia.databinding.ItemBatikBinding

class BatikAdapter : ListAdapter<BatikResponseItem, BatikAdapter.BatikViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikViewHolder {
        val binding=ItemBatikBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BatikViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BatikViewHolder, position: Int) {
        val batik=getItem(position)
        if (batik != null) {
            holder.bind(batik)
        }
    }

    class BatikViewHolder(private val binding:ItemBatikBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(batik: BatikResponseItem){
            binding.tvItemTitle.text=batik.namaBatik
            binding.tvItemAsal.text=batik.asalBatik
            Glide.with(itemView.context)
                .load(batik.urlGambar)
                .into(binding.imgBatik)

            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"Kamu memilih ${batik.namaBatik}",Toast.LENGTH_SHORT).show()
            }
        }

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BatikResponseItem>() {
            override fun areItemsTheSame(
                oldItem: BatikResponseItem,
                newItem: BatikResponseItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: BatikResponseItem,
                newItem: BatikResponseItem
            ): Boolean {
                return oldItem == newItem
            }

        }
    }


}