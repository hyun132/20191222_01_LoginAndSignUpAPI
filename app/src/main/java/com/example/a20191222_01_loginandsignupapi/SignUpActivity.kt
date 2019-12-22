package com.example.a20191222_01_loginandsignupapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsignupapi.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {
        signUpBtn.setOnClickListener {
            val inputId = idEdt.text.toString()
            val inputPw = pwEdt.text.toString()
            val inputName = nameEdt.text.toString()
            val inputPhone = phoneEdt.text.toString()

            ConnectServer.putRequestSignUp(mContext,inputId,inputPw,inputName,inputPhone, object : ConnectServer.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    Log.d("회원가입 응답", json.toString())

//                    서버가 내려주는 code값이 몇인지?확인
                    val code = json.getInt("code")
                    Log.d("회원가입코드", "${code}")

                    runOnUiThread {  if (code ==200){
                        Toast.makeText(mContext,"회원가입 성공입니다.",Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(mContext,"회원가입 실패입니다.",Toast.LENGTH_SHORT).show()
                    } }


                }
            })
        }
    }

    override fun setValues() {

    }


}
