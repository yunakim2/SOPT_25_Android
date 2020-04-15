package com.example.loginproject1.GitRepoChart

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.loginproject1.Data.GetGitRepoData
import com.example.loginproject1.R

class GitRepoViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    val gitRepoItemTitle : TextView =itemView.findViewById(R.id.txt_gitlist_title)
    val gitRepoItemSub : TextView =itemView.findViewById(R.id.txt_gitlist_sub)
    val gitRepoItemDate : TextView =itemView.findViewById(R.id.txt_gitlist_date)
    val gitRepoItemlag : TextView =itemView.findViewById(R.id.txt_gitlist_language)
    val gitRepoItemlagbtn : ImageView = itemView.findViewById(R.id.btn_gitlist_bt)

    fun bind(data : GetGitRepoData)
    {
        gitRepoItemTitle.text =  data.name
        gitRepoItemSub.text = data.description
        gitRepoItemDate.text = data.updatedAt
        gitRepoItemlag.text = data.language
        Glide.with(itemView)
            .load(R.drawable.plus)
            .into(gitRepoItemlagbtn)


    }

}
