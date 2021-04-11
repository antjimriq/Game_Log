package com.aeg7.gamelog.Api

import android.util.Log
import com.aeg7.gamelog.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
private val key = "7e8c32c7ac3140cd94a143252b925b94"
class MainRepository {

    suspend fun importGames():MutableList<Game>{
        return withContext(Dispatchers.IO){
            val gamesJsonResponse= service.listGames(key)
            Log.d("List_of_Games",gamesJsonResponse.toString())
            val listGames= parseResult(gamesJsonResponse)
            mutableListOf<Game>()
        }
    }

    private fun parseResult(gamesJsonResponse: GamesJsonResponse):MutableList<Game>{

        val gameList= mutableListOf<Game>()
        val results = gamesJsonResponse.results

        for (result in results){
            val id= result.id
            val name= result.name
            gameList.add(Game(id,name))
        }
        return gameList
    }
}