package com.aeg7.gamelog.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aeg7.gamelog.Game

@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tmList: MutableList<Game>)

    @Query("SELECT * FROM games")
    fun getTerremotos(): LiveData<MutableList<Game>>
}