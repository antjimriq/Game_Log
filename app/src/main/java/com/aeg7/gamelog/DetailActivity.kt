package com.aeg7.gamelog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aeg7.gamelog.Api.GameListAdapter
import com.aeg7.gamelog.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    companion object{
        const val KEY="terremoto"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}