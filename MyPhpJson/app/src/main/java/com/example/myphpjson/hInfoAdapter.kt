package com.example.myphpjson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.hinfo.view.*

class hInfoAdapter(var items : JsonObj) : RecyclerView.Adapter<hInfoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.hinfo, parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.result[position]
        holder.setItem(item)
    }

    override fun getItemCount() = items.result.count()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item: hInfo) {
            itemView.textView.text = item.name
            itemView.textView2.text = item.Age.toString()
            itemView.textView3.text = item.addr
        }
    }
}