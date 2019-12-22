package com.example.a20191222_01_loginandsignupapi.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
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

        val data = mList.get(position)

        val titleTxt = row.findViewById<TextView>(R.id.titleTxt)
        val contentTxt = row.findViewById<TextView>(R.id.contentTxt)
        val phoneNumTxt = row.findViewById<TextView>(R.id.phoneNumTxt)
        val writerNameTxt = row.findViewById<TextView>(R.id.writerNameTxt)

        titleTxt.text = data.title
        phoneNumTxt.text="${data.phoneNum}"
        contentTxt.text= data.content
        writerNameTxt.text = " -By : ${data.writer.name}"


        return row
    }
}