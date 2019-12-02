package com.example.loginproject1.FollowerChart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loginproject1.R

class FollowerRecyclerAdapter (var datas:List<FollowerRecyclerData>):RecyclerView.Adapter<FollowerRecyclerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerRecyclerViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item_follower, parent, false)

        return FollowerRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: FollowerRecyclerViewHolder, position: Int) {

        holder.bind(datas[position])

    }

}