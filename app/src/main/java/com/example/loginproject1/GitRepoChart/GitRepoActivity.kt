package com.example.loginproject1.GitRepoChart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.loginproject1.Adapter.FollowerRecyclerAdapter
import com.example.loginproject1.Adapter.GitRepoAdapter
import com.example.loginproject1.Api.GithubServiceImpl
import com.example.loginproject1.Data.FollowerData
import com.example.loginproject1.Data.FollowerRecyclerData
import com.example.loginproject1.Data.GetGitRepoData
import com.example.loginproject1.R
import kotlinx.android.synthetic.main.activity_follower.*
import kotlinx.android.synthetic.main.activity_git_repo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepoActivity : AppCompatActivity() {

    lateinit var gitrepoAdapter: GitRepoAdapter
    //lateinit var datas : List<GetGitRepoData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo)
        makeprofile()
        makeGitRepoList()
    }

    fun makeprofile()
    {
        txt_gitrepo_gitID.text = intent.getStringExtra("gitID")
        txt_gitrepo_name.text = intent.getStringExtra("name")
        txt_gitrepo_title.text =intent.getStringExtra("title")
        txt_gitrepo_subtitle.text = intent.getStringExtra("subtitle")
        Glide.with(this)
            .load(R.drawable.dongdong)
            .into(img_gitrepo_profile)
    }
    fun makeGitRepoList()
    {
        val userRepo = GithubServiceImpl.service.getRepos("yunakim2")

        userRepo.enqueue(object : Callback<List<GetGitRepoData>> {
            override fun onFailure(call: Call<List<GetGitRepoData>>, t: Throwable) {
                Log.v("GET","GitRepo 연결 실패")
            }

            override fun onResponse(call: Call<List<GetGitRepoData>>, response: Response<List<GetGitRepoData>>) {
                var datas = response.body()!!
                gitrepoAdapter = GitRepoAdapter(datas)
                gitrepoAdapter.notifyDataSetChanged()
                rv_gitrepo_list.layoutManager = LinearLayoutManager(this@GitRepoActivity, LinearLayoutManager.VERTICAL,false)
                rv_gitrepo_list.adapter = gitrepoAdapter

            }

        })
       /* datas = listOf(
            GitRepoData("Sopt세미나","로그인,회원가입화면 구현","OCT 22","Kotlin",R.drawable.plus),
            GitRepoData("Sopt세미나","리사이클러뷰 구현","OCT 30","Kotlin",R.drawable.plus),
            GitRepoData("Sopt세미나","서버 구현","NOV 14","Kotlin",R.drawable.plus),
            GitRepoData("Sopt세미나","디자인 합동세미나 ","NOV 22","Kotlin",R.drawable.plus),
            GitRepoData("Sopt세미나","서버 합동세미나 ","NOV 29","Kotlin",R.drawable.plus)


        )
        gitrepoAdapter = GitRepoAdapter(datas)
        gitrepoAdapter.notifyDataSetChanged()
        rv_gitrepo_list.layoutManager = LinearLayoutManager(this@GitRepoActivity, LinearLayoutManager.VERTICAL,false)
        rv_gitrepo_list.adapter = gitrepoAdapter*/
    }
}

