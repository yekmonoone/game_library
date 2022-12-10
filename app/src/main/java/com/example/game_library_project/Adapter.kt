package com.example.game_library_project


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.game_library_project.databinding.RecyclerviewItemLayoutBinding

class Adapter(val gameList : ArrayList<GamesInfo>) : RecyclerView.Adapter<Adapter.GameHolder>(){

    class GameHolder(val binding: RecyclerviewItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        val binding = RecyclerviewItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GameHolder(binding)
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {

        //game detail kısmına gitmek için
        //val intent = Intent(holder.itemView.context, detailedgame....::class.java)
        holder.binding.gameImage.setImageResource(gameList.get(position).gameImage)
        holder.binding.gameName.text = gameList.get(position).gameName
        holder.binding.score.text = gameList.get(position).score.toString()
        holder.binding.genre.text = gameList.get(position).genre

    }

    override fun getItemCount(): Int {
        return gameList.size
    }



}