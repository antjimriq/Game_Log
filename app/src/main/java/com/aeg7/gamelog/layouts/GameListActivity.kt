package com.aeg7.gamelog.layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aeg7.gamelog.api.GameAdapter
import com.aeg7.gamelog.Game
import com.aeg7.gamelog.GameDetails
import com.aeg7.gamelog.MainViewModel
import com.aeg7.gamelog.MainViewModelFactory
import com.aeg7.gamelog.databinding.ActivityGameListBinding

class GameListActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGameListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.myGamesRecycler.layoutManager=LinearLayoutManager(this)
        val adapter = GameAdapter(this)
        binding.myGamesRecycler.adapter = adapter
        adapter.setOnclickListener {
            openGameListDetailActivity(it)
        }
        viewModel= ViewModelProvider(this,
            MainViewModelFactory(application)
        ).get(MainViewModel::class.java)
        viewModel.myGamesList.observe(this, Observer { myGamesList ->
            adapter.submitList(myGamesList)
            handelEmptyList(myGamesList, binding)
        })
    }
    private fun handelEmptyList(
        myGamesList: MutableList<Game>,
        binding: ActivityGameListBinding
    ) {
        if (myGamesList.isEmpty()) {
            binding.emptyList.visibility = View.VISIBLE
        } else {
            binding.emptyList.visibility = View.GONE
        }
    }
    private fun openGameListDetailActivity (game: Game){
        val intent=Intent(this, GameDetails::class.java)
        intent.putExtra(GameDetails.KEY,game)
        startActivity(intent)
    }
}
