package com.example.game_library_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Adapter(private val gameList : ArrayList<GamesInfo>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_layout,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = gameList[position]
        holder.gameImage.setImageResource(currentItem.gameImage)
        holder.gameName.text = currentItem.gameName
        holder.score.text = currentItem.score
        holder.negre.text = currentItem.negre
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val gameImage : ShapeableImageView = itemView.findViewById(R.id.gameImage)
        val gameName : TextView = itemView.findViewById(R.id.gameName)
        val score : TextView = itemView.findViewById(R.id.score)
        val negre : TextView = itemView.findViewById(R.id.negre)
    }


}