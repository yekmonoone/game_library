package com.example.game_library_project

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.game_library_project.databinding.FragmentGamesBinding
import java.util.*
import kotlin.collections.ArrayList



class Games : Fragment() {

    private lateinit var displaylist: ArrayList<GamesInfo>
    private lateinit var gamesArrayList: ArrayList<GamesInfo>
    private lateinit var searchbar: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(
        view: View, savedInstanceState: Bundle?
    ) {

        gamesArrayList = arrayListOf<GamesInfo>()


        val gtaV = GamesInfo(
            R.drawable.gta_5,
            "Grand Theft Auto V",
            96,
            "Action, Shooter",
            getString(R.string.gtaV)
        )
        val portal2 = GamesInfo(
            R.drawable.portal2,
            "Portal 2",
            95,
            "Action, Puzzle",
            getString(R.string.portal2)
        )
        val witcher = GamesInfo(
            R.drawable.witcher,
            "The Witcher 3: Wild Hunt",
            89,
            "Action, Puzzle",
            getString(R.string.witcher)
        )
        val left4dead2 = GamesInfo(
            R.drawable.left4dead2,
            "Left 4 Dead 2",
            89,
            "Action, Puzzle",
            getString(R.string.left4dead2)
        )
        val left4dead1 = GamesInfo(
            R.drawable.left4dead2,
            "Left 4 Dead 2",
            89,
            "Action, Puzzle",
            getString(R.string.left4dead2)
        )

        gamesArrayList.add(gtaV)
        gamesArrayList.add(portal2)
        gamesArrayList.add(witcher)
        gamesArrayList.add(left4dead2)
        gamesArrayList.add(left4dead1)
        displaylist = arrayListOf<GamesInfo>()
        displaylist.addAll(gamesArrayList)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchbar = view.findViewById(R.id.searchView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(displaylist)
        recyclerView.adapter = adapter

        /*view.recyclerView.layoutManager = LinearLayoutManager(context)
        view.recyclerView.adapter = Adapter(displaylist)
        */

        searchbar.clearFocus()

        searchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchbar.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                displaylist.clear()
                val searchtext = newText!!.toLowerCase(Locale.getDefault())
                if (searchtext.isEmpty()) {
                    recyclerView.visibility = View.GONE
                }
                if (searchtext.length >= 3) {
                    gamesArrayList.forEach() {
                        recyclerView.visibility = View.VISIBLE
                        if (it.gameName.toLowerCase(Locale.getDefault()).contains(searchtext)) {
                            displaylist.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    displaylist.clear()
                    displaylist.addAll(gamesArrayList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_games, container, false)
        return view
    }
}