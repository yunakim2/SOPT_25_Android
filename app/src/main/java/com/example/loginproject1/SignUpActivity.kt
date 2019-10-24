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
        btSignUp.setOnClickListener {
            val name = etName.text.toString()
            val id = etID.text.toString()
            val pw = etPassword.text.toString()
            val pwck  = etPWcheck.text.toString()


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
