package com.example.game_library_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_favorites.view.*
import kotlinx.android.synthetic.main.fragment_games.view.*
import kotlinx.android.synthetic.main.fragment_games.view.recyclerView


class Favorites : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        val  favoritedGamesArrayList = ArrayList<GamesInfo>()

        val gta5 = GamesInfo(R.drawable.gta_5,"Grand Theft Auto V", 96, "Action, Shooter",getString(R.string.gtaV))
       favoritedGamesArrayList.add(gta5)



        val view = inflater.inflate(R.layout.fragment_favorites,container,false)
        view.recyclerView.layoutManager = LinearLayoutManager(context)
        view.recyclerView.adapter = Adapter(favoritedGamesArrayList)
        val size : Int = favoritedGamesArrayList.size
        view.favoritedNumber.text = "($size)"
        if (favoritedGamesArrayList.isEmpty()){
            view.noFavorited.visibility = View.VISIBLE
            view.favoritedNumber.visibility = View.INVISIBLE
        }

        // Inflate the layout for this fragment
        return view
    }




    }


