package com.aeg7.gamelog.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aeg7.gamelog.Game
import com.aeg7.gamelog.R

class MyGamesListActivity : AppCompatActivity() {

    companion object{
        const val MYGAMES_KEY = "mygames"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_game_list)
        //Debes acceeder a la DB y coger todos los juegos que tenga myGame a true

/*        val mygame=intent.extras?.getParcelable<Game>(MYGAMES_KEY)

        Log.d("MyGamesListActivity","Se recibe el juego $mygame")
        println("Aquiii--------------------------------"+mygame?.myGame)*/
    }
}