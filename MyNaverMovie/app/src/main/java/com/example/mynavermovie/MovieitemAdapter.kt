package com.example.mynavermovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movieitem.view.*

class MovieitemAdapter (var items:ArrayList<Movieitem>) : RecyclerView.Adapter<MovieitemAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieitemAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movieitem,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: MovieitemAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setItem(item:Movieitem){
            itemView.name.text = item.title
            itemView.score1.text = item.score1
            itemView.score2.text = item.score2
            itemView.reserve.text = "예매율 : " + item.reserve + "%"
            Glide.with(itemView).load(item.imgsrc).into(itemView.poster)
        }
    }
}