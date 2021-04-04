package com.aeg7.gamelog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class GameListAdapter: ListAdapter<Game,GameListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.my_games_list_object,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameListAdapter.ViewHolder, position: Int) {
        val game= getItem(position)
        holder.bind(game)
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val logoImage=view.findViewById<ImageView>(R.id.game_logo)
        private val nameText=view.findViewById<TextView>(R.id.game_name)
        private val plattformText=view.findViewById<TextView>(R.id.game_plattform)
        fun bind(game: Game){
            nameText.text=game.name
            plattformText.text=game.plattform
            val icon= when(game) {//TODO enlazar para que la imagen la coja de la database

            }
        }

    }

}