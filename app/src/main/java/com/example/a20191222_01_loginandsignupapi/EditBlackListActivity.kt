package com.example.a20191222_01_loginandsignupapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.a20191222_01_loginandsignupapi.datas.BlackListData
import com.example.a20191222_01_loginandsignupapi.datas.User
import com.example.a20191222_01_loginandsignupapi.utils.ConnectServer
import com.example.a20191222_01_loginandsignupapi.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_edit_black_list.*
import kotlinx.android.synthetic.main.activity_edit_black_list.phoneEdt
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class EditBlackListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_black_list)
    }
    override fun setupEvents() {

        addBlackListBtn.setOnClickListener {

//            사용자가 입력한 값을 저장
            val inputPhone = phoneEdt.text.toString()
            val inputTitle = titleEdt.text.toString()
            val inputContext = contentEdt.text.toString()
//
//            var blackListData = BlackListData(phoneEdt.text.toString(),titleEdt.text.toString(),contentEdt.text.toString())
//            실제로 서버에 게시글 등록 API 를 호출하는 코드
            ConnectServer.postRequestBlackList(mContext,inputTitle,inputPhone,inputContext,object :ConnectServer.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    Log.d("게시글 등록 응답", json.toString())
                }

            })

        }

    }

    override fun setValues() {

    }


}
