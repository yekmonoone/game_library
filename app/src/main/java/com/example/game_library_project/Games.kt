package com.example.game_library_project

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.graphics.toColor
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.game_library_project.databinding.FragmentGamesBinding
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_games.*
import kotlinx.android.synthetic.main.fragment_games.view.*
import kotlinx.android.synthetic.main.recyclerview_item_layout.*
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.*
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList


class Games : Fragment() {

    lateinit var binding : FragmentGamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val gamesArrayList = ArrayList<GamesInfo>()
        val displaylist = ArrayList<GamesInfo>()
        val gtaV = GamesInfo(R.drawable.gta_5,"gtaV", 96, "Action, Shooter",getString(R.string.gtaV))
        val portal2 = GamesInfo(R.drawable.portal2,"Portal2", 95, "Action, Puzzle",getString(R.string.portal2))
        val witcher = GamesInfo(R.drawable.witcher, "The Witcher 3: Wild Hunt", 89, "Action, Puzzle",getString(R.string.witcher))
        val left4dead2 = GamesInfo(R.drawable.left4dead2,"Left4Dead2", 89, "Action, Puzzle",getString(R.string.left4dead2))

        gamesArrayList.add(gtaV)
        gamesArrayList.add(portal2)
        gamesArrayList.add(witcher)
        gamesArrayList.add(left4dead2)
        displaylist.addAll(gamesArrayList)


        val view = inflater.inflate(R.layout.fragment_games,container,false)
        view.recyclerView.layoutManager = LinearLayoutManager(context)
        view.recyclerView.adapter = Adapter(displaylist)



        /*
        GRI DONUSME CLICK LISTENER ÇALISMIYO
        adapter.setOnGameClickListener(object : Adapter.onGameClickListener{

            override fun onGameClick(position: Int) {
                Toast.makeText(activity,"as", Toast.LENGTH_SHORT).show()
            }


        })
        */


        /*
        SEARCH BAR CALISMIYO
        fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

            inflater.inflate(R.menu.bottom_nav_bar, menu)
            val menuItem = menu!!.findItem(R.id.searchView)

            if(menuItem != null){
                val searchView1 = menuItem.actionView as SearchView

                searchView1.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {

                        if(newText!!.isNotEmpty()){
                            displaylist.clear()
                            val search = newText.lowercase()
                            gamesArrayList.forEach{
                                if(it.gameName.lowercase().contains(search)){
                                    displaylist.add(it)
                                }
                            }
                            view.recyclerView.adapter!!.notifyDataSetChanged()
                        }
                        else{
                            displaylist.clear()
                            displaylist.addAll(gamesArrayList)
                            view.recyclerView.adapter!!.notifyDataSetChanged()
                        }
                        return true
                    }

                })
            }

            return super.onCreateOptionsMenu(menu, inflater)
        }*/




        /*
        3TEN FAZLA KARAKTER YAZINCA ARAMA CALISMIYO
        view.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                if(newText.count()<3){
                    gamesArrayList.(newText)
                }
                return false
            }

        })

         */

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