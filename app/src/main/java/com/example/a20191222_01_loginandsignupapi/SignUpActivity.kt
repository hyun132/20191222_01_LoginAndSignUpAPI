package com.example.a20191222_01_loginandsignupapi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsignupapi.utils.ConnectServer
import com.example.a20191222_01_loginandsignupapi.utils.ConnectServer.Companion.BASE_URL
import kotlinx.android.synthetic.main.activity_sign_up.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

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

                    val message = json.getString("message")



                    runOnUiThread {
                        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show()
                        if (code ==200){
                        finish()
                    }else{
                        Toast.makeText(mContext,"회원가입 실패입니다.",Toast.LENGTH_SHORT).show()
                    } }


                }
            })
        }

        fun postRequestLogin(context: Context, id:String, pw:String ,handler: ConnectServer.JsonResponseHandler){
            val client =OkHttpClient()
            val url = "${BASE_URL}/auth"

            val formData = FormBody.Builder()
                .add("login_id", id)
                .add("password",pw)
                .build()

            val request = Request.Builder()
                .url(url)
                .post(formData)
                .build()

            client.newCall(request).enqueue(object :Callback{
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {

                }

            })
        }

    }

    override fun setValues() {

    }


}
