package com.example.a20191222_01_loginandsignupapi.datas

import org.json.JSONObject
import java.io.Serializable

class BlackListData(phone:String, title:String ,content:String):Serializable {
    var phoneNum = phone
    var title = title
    var content =content

    constructor() : this("모름","미입력","미작성")

    companion object {
        fun getBlackListDataFromJson(json:JSONObject):BlackListData{
            val bld=BlackListData()

            bld.phoneNum = json.getString("phone_num")
            bld.title = json.getString("title")
            bld.content = json.getString("content")

            return bld
        }
    }
}