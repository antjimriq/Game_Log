package com.aeg7.gamelog.layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aeg7.gamelog.databinding.ActivityMyGamesDetailBinding


class MyGamesDetailActivity : AppCompatActivity() {
    companion object{
        const val KEY="game"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMyGamesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}