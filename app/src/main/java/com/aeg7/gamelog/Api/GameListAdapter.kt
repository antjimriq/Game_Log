package com.aeg7.gamelog.Api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aeg7.gamelog.Game
import com.aeg7.gamelog.R

class GameListAdapter():ListAdapter<Game, GameListAdapter.ViewHolder>(DiffCallback) {
    companion object DiffCallback: DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem==newItem
        }
    }
    lateinit var onItemClickListener: AdapterView.OnItemClickListener
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_games_list_object, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val game = getItem(position)
            holder.bind(game)
        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val logoImage = view.findViewById<ImageView>(R.id.game_logo)
            private val nameText = view.findViewById<TextView>(R.id.game_name)
            private val plattformText = view.findViewById<TextView>(R.id.game_plattform)
            fun bind(game: Game) {
                nameText.text = game.name
                plattformText.text = game.plattform
                //val icon = when (game) {//TODO enlazar para que la imagen la coja de la database
                }
            }
        }
