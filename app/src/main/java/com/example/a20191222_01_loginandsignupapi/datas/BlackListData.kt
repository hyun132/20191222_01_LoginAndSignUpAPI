package com.example.a20191222_01_loginandsignupapi.datas

import java.io.Serializable

class BlackListData(phone:String, title:String ,content:String):Serializable {
    var phoneNum = phone
    var title = title
    var content =content
}