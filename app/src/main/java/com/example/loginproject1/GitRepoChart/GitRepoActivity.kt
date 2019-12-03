package com.example.loginproject1.GitRepoChart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginproject1.Adapter.FollowerRecyclerAdapter
import com.example.loginproject1.Adapter.GitRepoAdapter
import com.example.loginproject1.Data.FollowerRecyclerData
import com.example.loginproject1.Data.GitRepoData
import com.example.loginproject1.R
import kotlinx.android.synthetic.main.activity_follower.*

class GitRepoActivity : AppCompatActivity() {

    lateinit var gitrepoAdapter: GitRepoAdapter
    lateinit var datas : List<GitRepoData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo)

        datas = listOf(
            GitRepoData("Sopt세미나","로그인,회원가입화면 구현","NOV 10","Kotlin",R.drawable.plus),
            GitRepoData("Sopt세미나","리사이클러뷰 구현","NOV 10","Kotlin",R.drawable.plus),
            GitRepoData("Sopt세미나","서버 구현","DEC 10","Kotlin",R.drawable.plus),
            GitRepoData("Sopt세미나","디자인 합동세미나 ","DEC 13","Kotlin",R.drawable.plus)


        )
        gitrepoAdapter = GitRepoAdapter(datas)
        gitrepoAdapter.notifyDataSetChanged()
        rv_follower_list.layoutManager = LinearLayoutManager(this@GitRepoActivity, LinearLayoutManager.VERTICAL,false)
        rv_follower_list.adapter = gitrepoAdapter
    }
}
