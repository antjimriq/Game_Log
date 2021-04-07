package com.aeg7.gamelog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.inflate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aeg7.gamelog.Api.GameListAdapter
import com.aeg7.gamelog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.myGamesRecycler.layoutManager=LinearLayoutManager(this)
        val viewModel: MainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        val adapter = GameListAdapter()
        binding.myGamesRecycler.adapter = adapter
        viewModel.myGamesList.observe(this, Observer { myGamesList ->
            adapter.submitList(myGamesList)
            handelEmptyList(myGamesList, binding)
        })
    }
    private fun handelEmptyList(
        myGamesList: MutableList<Game>,
        binding: ActivityMainBinding
    ) {
        if (myGamesList.isEmpty()) {
            binding.emptyList.visibility = View.VISIBLE
        } else {
            binding.emptyList.visibility = View.GONE
        }
    }
}
