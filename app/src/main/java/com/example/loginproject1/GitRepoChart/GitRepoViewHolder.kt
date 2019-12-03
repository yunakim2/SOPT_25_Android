package com.example.loginproject1.GitRepoChart

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.loginproject1.Data.FollowerRecyclerData
import com.example.loginproject1.Data.GitRepoData
import com.example.loginproject1.R

class GitRepoViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    val gitRepoItemTitle : TextView =itemView.findViewById(R.id.txt_gitlist_title)
    val gitRepoItemSub : TextView =itemView.findViewById(R.id.txt_gitlist_sub)
    val gitRepoItemDate : TextView =itemView.findViewById(R.id.txt_gitlist_date)
    val gitRepoItemlag : TextView =itemView.findViewById(R.id.txt_gitlist_language)
    val gitRepoItemlagbtn : ImageView = itemView.findViewById(R.id.btn_gitlist_bt)

    fun bind(data : GitRepoData)
    {
        gitRepoItemTitle.text =  data.title
        gitRepoItemSub.text = data.sub
        gitRepoItemDate.text = data.date
        gitRepoItemlag.text = data.language
        Glide.with(itemView)
            .load(data.btn)
            .into(gitRepoItemlagbtn)


    }

}
