package com.example.game_library_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_games.view.*



class Games : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val gamesArrayList = ArrayList<GamesInfo>()
        val gtaV = GamesInfo(R.drawable.gta5,"Grand Theft Auto V", 96, "Action, Shooter")
        val fifa = GamesInfo(R.drawable.fifa,"Fifa 2022", 96, "Sport")
        val witcher = GamesInfo(R.drawable.witcher, "The Witcher 3: Wild Hunt", 89, "Action, Puzzle")
        val pes = GamesInfo(R.drawable.pes,"Pro Evolution Soccer 20", 96, "Sport")

        gamesArrayList.add(gtaV)
        gamesArrayList.add(fifa)
        gamesArrayList.add(witcher)
        gamesArrayList.add(pes)

        val view = inflater.inflate(R.layout.fragment_games,container,false)
        view.recyclerView.layoutManager = LinearLayoutManager(context)
        view.recyclerView.adapter = Adapter(gamesArrayList)

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*BU ÇALIŞIYO
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(gamesArrayList)
        recyclerView.adapter = adapter
        */
    }


}