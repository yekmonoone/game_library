package com.example.game_library_project

import android.content.Intent
import android.content.res.loader.ResourcesProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    val favoritedGame = ArrayList<GamesInfo>()
    var selectedGame : GamesInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val gameName : TextView = findViewById(R.id.textViewDetail)
        val gameImage : ImageView = findViewById(R.id.imageViewDetail)
        val gameDescription: TextView = findViewById(R.id.textView2)
        val intent = intent
        selectedGame = intent.getSerializableExtra("gameInfo") as GamesInfo

        gameName.text = selectedGame!!.gameName
        gameImage.setImageResource(selectedGame!!.gameImage)

        gameDescription.text = selectedGame!!.info








    }



    fun buttonClick(view: View){
        val button2 :Button = findViewById(R.id.button2)

        if (selectedGame !in favoritedGame ) {
            favoritedGame.add(selectedGame!!)
            button2.text = "favorited"
            selectedGame!!.isFavorited = true
        }
        else{
            favoritedGame.remove(selectedGame!!)
            button2.text="add favorite"
        }


    }

}