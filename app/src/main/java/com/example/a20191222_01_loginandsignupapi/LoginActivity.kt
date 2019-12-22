package com.example.a20191222_01_loginandsignupapi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsignupapi.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        signUpBtn.setOnClickListener {
            val intent = Intent(mContext, SignUpActivity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            val inputId = idEdt.text.toString()
            val inputPw = pwEdt.text.toString()

            ConnectServer.postRequestSignUp(mContext, inputId,inputPw, object :ConnectServer.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {

                    Log.d("로그인 응답",json.toString())

                    val code = json.getInt("code")

                    if (code==200){

                    }else {
                        val message = json.getString("message")
                        runOnUiThread {
                            Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })
        }
    }

    override fun setValues() {

    }


}
