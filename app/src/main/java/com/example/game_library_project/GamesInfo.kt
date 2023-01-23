package com.example.game_library_project

import java.io.Serializable

data class GamesInfo(val gameImage : String, val gameName : String, val score : Int, val genre : String,var info : String,var website : String, var reddit : String, var isFavorited: Boolean=false):Serializable{

}
