package com.example.loginproject1.FollowerChart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.loginproject1.Adapter.FollowerRecyclerAdapter
import com.example.loginproject1.Api.GithubServiceImpl
import com.example.loginproject1.Api.ServerServiceImpl
import com.example.loginproject1.Data.FollowerData
import com.example.loginproject1.Data.FollowerRecyclerData
import com.example.loginproject1.Data.GetFollowerPageResponseData
import com.example.loginproject1.Data.GetUserData
import com.example.loginproject1.GitRepoChart.GitRepoActivity
import com.example.loginproject1.R
import com.example.loginproject1.ui.activity.SignUpActivity
import kotlinx.android.synthetic.main.activity_follower.*
import kotlinx.android.synthetic.main.activity_git_repo.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.list_item_follower.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FollowerActivity : AppCompatActivity() {

    lateinit var followerAdapter: FollowerRecyclerAdapter
    //lateinit var datas : List<FollowerData>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.loginproject1.R.layout.activity_follower)

        makeprofile()
        makeFollowerList()

        btn_gitRepo?.setOnClickListener {
            val intent = Intent(this@FollowerActivity, GitRepoActivity::class.java)
            intent.putExtra("gitID",txt_follower_gitID.text.toString())
            intent.putExtra("name",txt_follower_name.text.toString())
            intent.putExtra("title",txt_follower_title.text.toString())
            intent.putExtra("subtitle",txt_follower_subtitle.text.toString())
            startActivity(intent)
        }
    }
    fun makeprofile(){

        /*txt_follower_gitID.text = intent.getStringExtra("login")
        txt_follower_name.text = "Kim Yuna"
        txt_follower_title.text ="솝트 25기 YB 안드로이드 파트입니다."
        txt_follower_subtitle.text = "세미나 과제중 입니다."

        Glide.with(this)
            .load(R.drawable.dongdong)
            .into(img_follower_profile)*/
        val user = GithubServiceImpl.service.getUser("yunakim2")

        user.enqueue(object : Callback<GetUserData> {
            override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                txt_follower_gitID.text = response.body()!!.login
                txt_follower_name.text = response.body()!!.name
                txt_follower_title.text= response.body()!!.bio
                txt_follower_subtitle.text = "세미나 과제 중 입니다."

                Glide.with(this@FollowerActivity)
                    .load(response.body()!!.avatarUrl)
                    .into(img_follower_profile)

            }

            override fun onFailure(call: Call<GetUserData>, t: Throwable) {

                Log.v("GET","User profile 연결 실패")
            }
        })

    }
    fun makeFollowerList(){

        val userList =ServerServiceImpl.service.getUsersList(2)

        userList.enqueue(object : Callback<FollowerData> {
            override fun onFailure(call: Call<FollowerData>, t: Throwable) {

                Log.v("GET","Follower 연결 실패")
            }

            override fun onResponse(
                call: Call<FollowerData>,
                response: Response<FollowerData>
            ) {
                var datas = response.body()!!.data
                followerAdapter = FollowerRecyclerAdapter(datas)
                followerAdapter.notifyDataSetChanged()
                rv_follower_list.layoutManager = LinearLayoutManager(this@FollowerActivity, LinearLayoutManager.VERTICAL,false)
                rv_follower_list.adapter = followerAdapter

            }

        })

       /* datas = listOf(
            FollowerRecyclerData(
                R.drawable.dongdong,
                R.drawable.like, "유나1", "yunakim1"
            ),
            FollowerRecyclerData(
                R.drawable.dongdong,
                R.drawable.like,
                "유나2",
                "yunakim2"
            ),
            FollowerRecyclerData(
                R.drawable.dongdong,
                R.drawable.like,
                "유나3",
                "yunakim3"
            ),
            FollowerRecyclerData(
                R.drawable.dongdong,
                R.drawable.like,
                "유나4",
                "yunakim4"
            ),
            FollowerRecyclerData(
                R.drawable.dongdong,
                R.drawable.like,
                "유나5",
                "yunakim5"
            ),
            FollowerRecyclerData(
                R.drawable.dongdong,
                R.drawable.like,
                "유나6",
                "yunakim6"
            ),
            FollowerRecyclerData(
                R.drawable.dongdong,
                R.drawable.like,
                "유나7",
                "yunakim7"
            ),
            FollowerRecyclerData(
                R.drawable.dongdong,
                R.drawable.like,
                "유나8",
                "yunakim8"
            ),
            FollowerRecyclerData(
                R.drawable.dongdong,
                R.drawable.like,
                "유나9",
                "yunakim9"
            )
        )
        */
    }

}


