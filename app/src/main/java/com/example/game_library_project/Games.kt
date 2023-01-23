package com.example.game_library_project

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.game_library_project.databinding.FragmentGamesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
        println(8)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
                .addConverterFactory (GsonConverterFactory.create())
                .build()
        println(9)

        val api:Api = retrofit.create(Api::class.java)
        val call: Call<JSON> = api.getgames("3be8af6ebf124ffe81d90f514e59856c")
        displaylist = arrayListOf<GamesInfo>()
        gamesArrayList = arrayListOf<GamesInfo>()

        call.enqueue(object: Callback<JSON> {

            override fun onResponse (call: Call<JSON>, response: Response<JSON>) {
                if (response.isSuccessful) {
                    val gameList = response.body()?.results

                    var datagameList = ArrayList(gameList)

                    for (dataresult in datagameList){


                        val retrofitv2: Retrofit = Retrofit.Builder()
                            .baseUrl("https://api.rawg.io/api/")
                            .addConverterFactory (GsonConverterFactory.create())
                            .build()

                        val apiv2 :Api = retrofitv2.create(Api::class.java)
                        val callv2: Call<JSONDETAILS> = apiv2.getGameDescription(dataresult.id, "3be8af6ebf124ffe81d90f514e59856c")

                        callv2.enqueue(object: Callback<JSONDETAILS>{
                            override fun onResponse(call: Call<JSONDETAILS>, response: Response<JSONDETAILS>) {

                                if (response.isSuccessful) {

                                    val description = response.body()?.description!!
                                    val website = response.body()?.website!!
                                    val reddit = response.body()?.reddit_url!!
                                    val genres = dataresult.genres
                                    var genretypes = ""
                                    for (genre in genres) {
                                        genretypes = genretypes + genre.name + ","
                                    }
                                    val game = GamesInfo(
                                        dataresult.background_image,
                                        dataresult.name,
                                        dataresult.metacritic,
                                        genretypes,
                                        description,
                                        website,
                                        reddit
                                    )
                                    gamesArrayList.add(game)
                                    displaylist.add(game)
                                }
                                adapter.notifyDataSetChanged()
                            }
                            override fun onFailure(call: Call<JSONDETAILS>, t: Throwable) {
                                // handle failure
                            }
                        })
                    }
                    adapter.notifyDataSetChanged()
                } else {
                    // Handle error
                    println(4)
                    Log.e("API Call Error", "Error code: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<JSON>, t: Throwable) {
                TODO("Not yet implemented")
                println(5)
            }
        })




        /*val gtaV = GamesInfo(
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
         */

        //displaylist.addAll(gamesArrayList)


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