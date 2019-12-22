package com.example.a20191222_01_loginandsignupapi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.a20191222_01_loginandsignupapi.R
import com.example.a20191222_01_loginandsignupapi.datas.BlackListData

class BlackListAdapter(context: Context, resId:Int, list:ArrayList<BlackListData>):ArrayAdapter<BlackListData>(context,resId,list) {
    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        tempRow?.let{}.let {
            tempRow = inf.inflate(R.layout.black_list_item,null)
        }

        val row = tempRow!!



        return row
    }
}