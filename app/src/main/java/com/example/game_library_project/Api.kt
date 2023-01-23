package com.example.game_library_project

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("games")
    fun getgames(
        @Query("key") aKey: String
    ): Call<JSON>
    @GET("games/{id}")
    fun getGameDescription (
        @Path("id") id: Int,
        @Query("key") aKey: String
    ): Call<JSONDETAILS>
}