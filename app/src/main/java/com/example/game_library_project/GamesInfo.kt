package com.example.game_library_project

import java.io.Serializable

data class GamesInfo(val gameImage : Int, val gameName : String, val score : Int, val genre : String,var info : String,var isFavorited: Boolean=false):Serializable{

}
