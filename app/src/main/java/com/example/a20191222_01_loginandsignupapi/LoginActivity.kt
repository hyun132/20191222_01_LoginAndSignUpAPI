package com.example.a20191222_01_loginandsignupapi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsignupapi.datas.User
import com.example.a20191222_01_loginandsignupapi.utils.ConnectServer
import com.example.a20191222_01_loginandsignupapi.utils.ContextUtil
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
        val inputId = idEdt.text.toString()
        val inputPw = pwEdt.text.toString()

        loginBtn.setOnClickListener {

            val inputId = idEdt.text.toString()
            val inputPw = pwEdt.text.toString()

            ConnectServer.postRequestLogin(mContext, inputId, inputPw, object : ConnectServer.JsonResponseHandler {
                override fun onResponse(json: JSONObject) {

                    Log.d("로그인응답", json.toString())

                    val code = json.getInt("code")

                    if (code == 200) {

                        val data = json.getJSONObject("data")
                        val user = data.getJSONObject("user")

                        val userData = User.getUserDataFromJson(user)

//                        서버에서 내려주는 토큰값을 파싱
                        val token = data.getString("token")
//                        SharedPreference로 반영구 저장

                        ContextUtil.setUserToken(mContext,token)

                        val intent = Intent(mContext, MainActivity::class.java)
                        intent.putExtra("user",userData)
                        startActivity(intent)


                    }
                    else {
                        val message = json.getString("message")
                        runOnUiThread {
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                        }

                    }

                }

            })
        }
        signUpBtn.setOnClickListener {
            val intent = Intent(mContext, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun setValues() {

    }


}
