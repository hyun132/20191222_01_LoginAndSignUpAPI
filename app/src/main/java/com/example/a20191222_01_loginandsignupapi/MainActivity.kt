package com.example.a20191222_01_loginandsignupapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a20191222_01_loginandsignupapi.datas.BlackListData
import com.example.a20191222_01_loginandsignupapi.datas.User
import com.example.a20191222_01_loginandsignupapi.utils.ConnectServer
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {

    val blackList = ArrayList<BlackListData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }
    override fun setupEvents() {

    }

    override fun setValues() {

        val user = intent.getSerializableExtra("user") as User

        userNameAndIdTxt.text = "${user.name}(${user.loginId})"
        userPhoneTxt.text=user.phoneNum

        getBlackListsFromServer()
    }

    fun getBlackListsFromServer(){
        ConnectServer.getRequestBlackList(mContext,object :ConnectServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("블랙리스트목록응답",json.toString())
            }

        })
    }


}
