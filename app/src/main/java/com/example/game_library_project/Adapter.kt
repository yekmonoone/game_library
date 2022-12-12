package com.example.game_library_project


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
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



        holder.itemView.setOnClickListener{
            //tıklandıgı zaman renk degistirme
            holder.binding.cardview.setBackgroundColor(0x1F8E8E93)

            val intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("gameInfo",gameList.get(position))
            holder.itemView.context.startActivity(intent)
            //finish yapmamız gerekiyo mu?


        }

    }

    override fun getItemCount(): Int {
        return gameList.size
    }



}