package com.example.game_library_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




/**
 * A simple [Fragment] subclass.
 * Use the [Games.newInstance] factory method to
 * create an instance of this fragment.
 */
class Games : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var gamesArrayList: ArrayList<GamesInfo>

    lateinit var imageId : Array<Int>
    lateinit var gameName : Array<String>
    lateinit var score : Array<String>
    lateinit var negre : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Games.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Games().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(gamesArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){
        gamesArrayList = arrayListOf<GamesInfo>()


        imageId = arrayOf(
            R.drawable.gta5,
            R.drawable.fifa,
            R.drawable.pes
        )

        gameName = arrayOf(
            //getString(R.string.head_1),
            "gta5",
            //getString(R.string.head_2),
            "fifa",
            //getString(R.string.head_3)
            "pes"
        )

        score = arrayOf(
            //getString(R.string.score_1),
            "50",
            //getString(R.string.score_2),
            "77",
            //getString(R.string.score_3)
            "88"
        )

        negre = arrayOf(
            //getString(R.string.negre_1),
            "roleplay",
            //getString(R.string.negre_2),
            "soccer",
            //getString(R.string.negre_3)
            "soccer roleplay"
        )

        for (i in imageId.indices){
            val game = GamesInfo(imageId[i],gameName[i],score[i],negre[i])
            gamesArrayList.add(game)
        }


    }

}