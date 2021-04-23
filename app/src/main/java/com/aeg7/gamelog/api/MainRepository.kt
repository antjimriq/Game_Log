package com.aeg7.gamelog.api

import android.util.Log
import androidx.lifecycle.LiveData
import com.aeg7.gamelog.Game
import com.aeg7.gamelog.database.GamesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
private val key = "7e8c32c7ac3140cd94a143252b925b94"
class MainRepository(private val database:GamesDatabase) {

    suspend fun importGames():MutableList<Game>{
        return withContext(Dispatchers.IO){
            val gamesJsonResponse= service.listGames(key)
            Log.d("List_of_Games",gamesJsonResponse.toString())
            val listGames= parseResult(gamesJsonResponse)
            database.gameDao.insertAll(listGames)
            listGames.forEach { println(it) }
            listGames
        }
    }

    suspend fun gamesfromDB(): LiveData<MutableList<Game>> {
        return withContext(Dispatchers.IO){
        database.gameDao.getGames()
        }
    }

    private fun parseResult(gamesJsonResponse: GamesJsonResponse):MutableList<Game>{

        val gameList= mutableListOf<Game>()
        val results = gamesJsonResponse.results

        for (result in results){
            val id= result.id
            val name= result.name
            val plataformas= mutableListOf<String>()
            for (plataforma in result.platforms)
                plataformas.add(plataforma.platform.name)
            gameList.add(Game(id,name,result.backgorund_image,plataformas))
        }
        return gameList
    }
}