package com.example.a20191222_01_loginandsignupapi

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    var mContext = this

    abstract fun setupEvents()
    abstract fun setValues()
}