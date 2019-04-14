package com.example.a81809.animation_test_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ReceiverAdapter(private val context :Context,private val names : Array<String>,private val addresses:Array<String>):  BaseAdapter(){

    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: createView(parent)
        val name = names[position]
        val address = getItem(position)

        val viewHolder = view.tag as ViewHolder

        viewHolder.name.text = name
        viewHolder.address.text = address
        viewHolder.icon.setColorFilter(300)

        return view
    }

    override fun getItem(position: Int) = addresses[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() =addresses.size

    private class ViewHolder(view:View){
        val name = view.findViewById<TextView>(R.id.receiver_name)
        val address = view.findViewById<TextView>(R.id.receiver_address)
        val icon =view.findViewById<ImageView>(R.id.receiver_icon)
    }

    private fun createView(parent: ViewGroup?) :View{
        val view = inflater.inflate(R.layout.receiver_list_row,parent,false)
        view.tag = ViewHolder(view)
        return view
    }

}