package com.example.game_library_project

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_favorites.view.*
import kotlinx.android.synthetic.main.fragment_games.view.*
import kotlinx.android.synthetic.main.fragment_games.view.recyclerView


class Favorites : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : Adapter
    private lateinit var favoritedGamesArrayList : ArrayList<GamesInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_favorites, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val data = arguments
        val favgame = data!!.getSerializable("key") as GamesInfo
        favoritedGamesArrayList.add(favgame)

         */



        favoritedGamesArrayList = ArrayList<GamesInfo>()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(favoritedGamesArrayList)
        recyclerView.adapter = adapter


        val size : Int = favoritedGamesArrayList.size
        favoritedNumber.text ="($size)"
        if (favoritedGamesArrayList.isEmpty()){
            noFavorited.visibility = View.VISIBLE
            favoritedNumber.visibility = View.INVISIBLE
        }



    }






    }


