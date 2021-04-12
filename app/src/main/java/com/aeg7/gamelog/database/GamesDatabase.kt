package com.aeg7.gamelog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aeg7.gamelog.Game

@Database(entities = [Game::class],version = 1)
abstract class GamesDatabase: RoomDatabase(){
abstract val gameDao: GameDao
}
private lateinit var INSTANCE:GamesDatabase
fun getDatabase(context: Context):GamesDatabase{
    synchronized(GamesDatabase::class.java){
        if (!::INSTANCE.isInitialized){
            INSTANCE= Room.databaseBuilder(context.applicationContext,GamesDatabase::class.java,"games_db").build()
        }
        return INSTANCE
}
}