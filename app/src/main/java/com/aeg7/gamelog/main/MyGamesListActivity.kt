package com.aeg7.gamelog.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.aeg7.gamelog.Game
import com.aeg7.gamelog.MainViewModel
import com.aeg7.gamelog.R
import com.aeg7.gamelog.api.GameAdapter
import com.aeg7.gamelog.database.getDatabase
import com.aeg7.gamelog.databinding.ActivityMyGameListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyGamesListActivity : AppCompatActivity() {

    companion object{
        const val MYGAMES_KEY = "mygames"
    }
    var myGames= mutableListOf<Game>()
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_game_list)
        val binding = ActivityMyGameListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.gameListRecycler.layoutManager= LinearLayoutManager(this)
        val adapter = GameAdapter(this)
        binding.gameListRecycler.adapter = adapter
        adapter.setOnclickListener {
            openMyGameListDetailActivity(it)
        }
        runBlocking {
            launch(Dispatchers.IO){
                var database= getDatabase(application)
                myGames=database.gameDao.getMyGames()
            }
        }

        println("Aquiii estan mygames-----------------------------$myGames")
        adapter.submitList(myGames)

        //Cambiamos titulo del toolbar
        supportActionBar?.title="My Games"

/*        viewModel= ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        viewModel.myGamesList.observe(this, Observer { myGamesList ->
            adapter.submitList(myGames)
        })*/
        //Debes acceeder a la DB y coger todos los juegos que tenga myGame a true

/*        val mygame=intent.extras?.getParcelable<Game>(MYGAMES_KEY)

        Log.d("MyGamesListActivity","Se recibe el juego $mygame")
        println("Aquiii--------------------------------"+mygame?.myGame)*/
    }
    private fun openMyGameListDetailActivity (game: Game){
        val intent= Intent(this, GameDetailsActivity::class.java)
        println("aquii el juegoo jeje---------------------------------${game?.preferences.comments}")
        intent.putExtra(GameDetailsActivity.GAME_KEY,game)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mygames_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.save_menu) {
            //(activity as GameDetailsActivity).saveData()
        }
        return super.onOptionsItemSelected(item)
    }
}