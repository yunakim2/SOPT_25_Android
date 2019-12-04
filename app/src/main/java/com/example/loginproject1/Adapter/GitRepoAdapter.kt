package com.example.loginproject1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loginproject1.Data.GitRepoData
import com.example.loginproject1.GitRepoChart.GitRepoViewHolder

import com.example.loginproject1.R

class GitRepoAdapter( var datas:List<GitRepoData>): RecyclerView.Adapter<GitRepoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_gitrepo, parent, false)

        return GitRepoViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {

        holder.bind(datas[position])

    }

}