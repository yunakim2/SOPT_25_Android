package com.example.loginproject1.FollowerChart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginproject1.R
import kotlinx.android.synthetic.main.activity_follower.*



class FollowerActivity : AppCompatActivity() {
    private  var follower_profile : ImageView?= null
    private var follower_gitid: TextView?= null
    private  var follower_name : TextView?= null
    private  var follower_title : TextView?= null
    private  var follower_subtitle : TextView?= null
    lateinit var followerAdapter: FollowerRecyclerAdapter
    lateinit var datas : List<FollowerRecyclerData>
        //response.body()!!.data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.loginproject1.R.layout.activity_follower)

        datas = listOf(FollowerRecyclerData(com.example.loginproject1.R.drawable.dongdong,
            R.drawable.like,"유나1","yunakim1"),
            FollowerRecyclerData(com.example.loginproject1.R.drawable.dongdong,R.drawable.like,"유나2","yunakim2"),
            FollowerRecyclerData(com.example.loginproject1.R.drawable.dongdong,R.drawable.like,"유나3","yunakim3"),
            FollowerRecyclerData(com.example.loginproject1.R.drawable.dongdong,R.drawable.like,"유나4","yunakim4"),
            FollowerRecyclerData(com.example.loginproject1.R.drawable.dongdong,R.drawable.like,"유나5","yunakim5"),
            FollowerRecyclerData(com.example.loginproject1.R.drawable.dongdong,R.drawable.like,"유나6","yunakim6"),
            FollowerRecyclerData(com.example.loginproject1.R.drawable.dongdong,R.drawable.like,"유나7","yunakim7"),
            FollowerRecyclerData(com.example.loginproject1.R.drawable.dongdong,R.drawable.like,"유나8","yunakim8"),
            FollowerRecyclerData(com.example.loginproject1.R.drawable.dongdong,R.drawable.like,"유나9","yunakim9"))
        followerAdapter = FollowerRecyclerAdapter(datas)
        followerAdapter.notifyDataSetChanged()
        rv_follower_list.layoutManager = LinearLayoutManager(this@FollowerActivity, LinearLayoutManager.VERTICAL,false)
        rv_follower_list.adapter = followerAdapter
    }

}


