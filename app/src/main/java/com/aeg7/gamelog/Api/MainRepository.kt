package com.aeg7.gamelog.Api

import android.util.Log
import com.aeg7.gamelog.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
private val apiKey = "7e8c32c7ac3140cd94a143252b925b94"
class MainRepository {
    suspend fun importGames():MutableList<Game>{
        return withContext(Dispatchers.IO){
            val list= service.listGames(apiKey)
            Log.d("List_of_Games",list)
            mutableListOf<Game>()
        }
    }
}