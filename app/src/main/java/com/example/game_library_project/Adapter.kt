package com.example.game_library_project


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.game_library_project.databinding.RecyclerviewItemLayoutBinding

class Adapter(val gameList : ArrayList<GamesInfo>) : RecyclerView.Adapter<Adapter.GameHolder>(){


    /*

    CLICK LISTENER
    private lateinit var mListener: onGameClickListener


    interface onGameClickListener{

        fun onGameClick(position: Int)


    }

    fun setOnGameClickListener(listener: onGameClickListener){

        mListener = listener

    }
    */



    class GameHolder(val binding: RecyclerviewItemLayoutBinding/*,listener: onGameClickListener*/) : RecyclerView.ViewHolder(binding.root){

        /*init {

            itemView.setOnClickListener {
                listener.onGameClick(adapterPosition)
            }

        }

         */

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        val binding = RecyclerviewItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GameHolder(binding/*,mListener*/)
    }

        //private var row_index = -1

    override fun onBindViewHolder(holder: GameHolder, position: Int) {

        //game detail kısmına gitmek için
        //val intent = Intent(holder.itemView.context, detailedgame....::class.java)
        holder.binding.gameImage.setImageResource(gameList.get(position).gameImage)
        holder.binding.gameName.text = gameList.get(position).gameName
        holder.binding.score.text = gameList.get(position).score.toString()
        holder.binding.genre.text = gameList.get(position).genre


        /*if (row_index === position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#E0E0E0"))
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"))
        }

         */


    }

    override fun getItemCount(): Int {
        return gameList.size
    }



}