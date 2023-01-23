package com.example.game_library_project

import android.content.Intent
import android.content.res.loader.ResourcesProvider
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    val favoritedGame = ArrayList<GamesInfo>()
    var selectedGame : GamesInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gameName : TextView = findViewById(R.id.textViewDetail)
        val reddit : TextView = findViewById(R.id.redditView)
        val website : TextView = findViewById(R.id.websiteView)
        val gameDescription: TextView = findViewById(R.id.textView2)
        val intent = intent
        
        selectedGame = intent.getSerializableExtra("gameInfo") as GamesInfo



        //val favoritedintent = Intent(this@DetailActivity, Favorites::class.java)
        //favoritedintent.putExtra("key", favoritedGame)
        //startActivity(favoritedintent)

        gameName.text = selectedGame!!.gameName
        Picasso.get().load(selectedGame?.gameImage).into(findViewById<ImageView>(R.id.imageViewDetail))
        gameDescription.text = selectedGame!!.info
        //reddit.text = selectedGame!!.reddit
        val redditurl = selectedGame!!.reddit
        //website.text = selectedGame!!.website
        val websiteurl = selectedGame!!.website

        val expandableTextView = findViewById<TextView>(R.id.textView2)
        expandableTextView.maxLines = 4
        val initialMaxLines = expandableTextView.maxLines
        expandableTextView.setOnClickListener {
            expandableTextView.maxLines = if (expandableTextView.maxLines == initialMaxLines) {
                expandableTextView.setTextSize(7.5F)
                Int.MAX_VALUE
            } else {
                expandableTextView.setTextSize(10.0F)
                initialMaxLines
            }
        }

        reddit.setOnClickListener {
            val openreddit = Intent(android.content.Intent.ACTION_VIEW)
            openreddit.data = Uri.parse(redditurl)
            startActivity(openreddit)
        }

        website.setOnClickListener {
            val openweb = Intent(android.content.Intent.ACTION_VIEW)
            openweb.data = Uri.parse(websiteurl as String)
            startActivity(openweb)
        }
    }

    fun buttonClick(view: View){
        val button2 :Button = findViewById(R.id.button2)

        if (selectedGame !in favoritedGame ) {

            /*val bundle = Bundle()
            val fragment = Favorites()
            fragment.arguments = bundle
            bundle.putSerializable("key",selectedGame)

             */

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

