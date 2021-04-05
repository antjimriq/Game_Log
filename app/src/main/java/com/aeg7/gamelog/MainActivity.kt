package com.aeg7.gamelog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aeg7.gamelog.Api.GameListAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = inflate(layoutInflater)
        setContentView(binding.root)
        binding.my_games_recycler.layoutManager = LinearLayoutManager(this)
        val adapter = GameListAdapter()
        binding.my_games_recycler.adapter = adapter
        val viewModel: MainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        viewModel.myGamesList.observe(this, Observer { tmList ->
            adapter.submitList(my_games_list)
    }
    }
}