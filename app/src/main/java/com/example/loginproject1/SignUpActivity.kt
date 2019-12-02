package com.example.loginproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        makeController()
    }

    fun makeController()
    {
        btn_signup_check.setOnClickListener {
            val name = edit_signup_name.text.toString()
            val id = edit_signup_id.text.toString()
            val pw = edit_signup_pw.text.toString()
            val pwck  = edit_signup_checkpw.text.toString()

            if(name.isEmpty() || id.isEmpty() || pw.isEmpty()|| pwck.isEmpty())
            {
                Toast.makeText(this, "내용을 채워주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(pw!=pwck)
            {
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val res = requestSignUp(name,id,pw)

            if(res)
            {
                finish()
            }
            else
            {
                Toast.makeText(this,"회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun requestSignUp(name:String, id :String , pw:String) : Boolean
    {
        return true
    }
}
