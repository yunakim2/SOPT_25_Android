package com.example.loginproject1.FollowerChart

import android.content.Intent
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.loginproject1.Data.FollowerRecyclerData
import com.example.loginproject1.GitRepoChart.GitRepoActivity
import com.example.loginproject1.R
import kotlinx.android.synthetic.main.activity_follower.*

class FollowerRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val followerItemName : TextView =itemView.findViewById(R.id.txt_list_Name)
    val followerItemGit : TextView=itemView.findViewById(R.id.txt_list_gitID)
    val followerItemImg : ImageView= itemView.findViewById(R.id.img_list_profile)
    val followerItemIcon : ImageButton = itemView.findViewById(R.id.img_list_icon)
    fun bind(data : FollowerRecyclerData)
    {
        followerItemName.text = data.Name
        followerItemGit.text = data.gitID
        Glide.with(itemView)
            .load(data.img)
            .into(followerItemImg)
        Glide.with(itemView)
            .load(data.icon)
            .into(followerItemIcon)

    }

}