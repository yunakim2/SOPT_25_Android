package com.example.loginproject1.FollowerChart

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.loginproject1.Data.FollowerRecyclerData
import com.example.loginproject1.R

class FollowerRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val followerItemName : TextView =itemView.findViewById(R.id.txt_list_Name)
    val followerItemGit : TextView=itemView.findViewById(R.id.txt_list_gitID)
    val followerItemImg : ImageView= itemView.findViewById(R.id.img_list_profile)
    val followerItemIcon : ImageView = itemView.findViewById(R.id.img_list_icon)
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