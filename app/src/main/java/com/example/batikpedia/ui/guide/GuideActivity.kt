package com.example.batikpedia.ui.guide

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batikpedia.R
import com.example.batikpedia.data.response.Member
import com.example.batikpedia.databinding.ActivityGuideBinding

class GuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuideBinding

    private val list = ArrayList<Member>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val rvMember = binding.rvTeamMember
        rvMember.setHasFixedSize(true)
        rvMember.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        list.addAll(getListMember())
        showRecyclerList()

        binding.btnFigma.setOnClickListener {
            val url =
                "https://www.figma.com/file/DBAhUHoDYacLIH7HE9C3tU/Batikpedia?type=design&node-id=3%3A2&mode=design&t=AnolsfcgPiiIdFri-1"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        binding.btnGithub.setOnClickListener {
            val url = "https://github.com/BatikPedia-Capstone"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)


        }

        binding.btnColab.setOnClickListener {
            val url="https://colab.research.google.com/drive/1YlHZdGAVoVAjMzr5nKnEP0VXRXJky6mN?usp=sharing"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        binding.btnProjectPlan.setOnClickListener{
            val url="https://docs.google.com/document/d/1StI7ER6A9o7r9tEcm203CzvOpXLLh130Aj0no-v3rkk/edit"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

    private fun getListMember(): ArrayList<Member> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listMember = ArrayList<Member>()
        for (position in dataName.indices) {
            val member = Member(
                dataName[position],
                dataRole[position],
                dataPhoto[position]
            )
            listMember.add(member)
        }
        return listMember

    }

    private fun showRecyclerList() {
        val listMemberAdapter = MemberAdapter(list)
        binding.rvTeamMember.adapter = listMemberAdapter

        listMemberAdapter.setOnItemClickCallback(object : OnItemClickCallback {
            override fun onItemClicked(data: Member) {
                Toast.makeText(this@GuideActivity, "Mantap !!" + data.name+" diklik nih! Dia jago di bidang " + data.role + " , lho!" , Toast.LENGTH_SHORT).show()
            }
        })

    }


}