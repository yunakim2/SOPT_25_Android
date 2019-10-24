package com.example.loginproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {

    private var editSignInID : EditText? = null
    private  var editSignInPW : EditText? = null
    private var btnSignInSignUp : Button?= null
    private var btnSignInSignIn : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        Log.d("with sopt","sign in activity in created")

        makeController()


    }


    private fun makeController()
    {
        editSignInID = findViewById(R.id.editTextID)
        editSignInPW = findViewById(R.id.editTextPW)
        btnSignInSignIn = findViewById(R.id.btLogin)
        btnSignInSignUp = findViewById(R.id.btSignIn)

        btnSignInSignUp?.setOnClickListener {

                    val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
                    startActivity(intent)

        }

        btnSignInSignIn?.setOnClickListener {
            val id = editSignInID?.text.toString()
            val pw = editSignInPW?.text.toString()

            if(id.isEmpty() || pw.isEmpty())
            {
                Toast.makeText(this,"아이디나 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val res = requestLogin(id,pw)
            if(res)
            {

                val intent = Intent(this@SignInActivity, Myprofile::class.java)
                startActivity(intent)

            }
            else
            {
                Toast.makeText(this,"로그인 실패하였습니다.", Toast.LENGTH_SHORT).show()
                editSignInID?.requestFocus()

            }

        }
    }

    private fun requestLogin(id:String,pw:String):Boolean{

        return true
    }

}
