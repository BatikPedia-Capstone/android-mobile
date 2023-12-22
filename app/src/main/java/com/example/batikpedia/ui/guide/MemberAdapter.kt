package com.example.batikpedia.ui.guide

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikpedia.R
import com.example.batikpedia.data.response.Member

class MemberAdapter(private val listMember: ArrayList<Member>) :
    RecyclerView.Adapter<MemberAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_member, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMember.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val member = listMember[position]

        holder.ivPhoto.setImageResource(R.drawable.ic_launcher_background)
        holder.tvName.text = member.name
        holder.tvRole.text = member.role
        Glide.with(holder.itemView.context)
            .load(member.photo)
            .into(holder.ivPhoto)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name_member)
        val tvRole: TextView = itemView.findViewById(R.id.tv_item_role_member)
        val ivPhoto: ImageView = itemView.findViewById(R.id.img_member)

    }

}

interface OnItemClickCallback {

    fun onItemClicked(data: Member)
}
