package com.aeg7.gamelog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


open class my_games_list : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_my_games_list, container, false)
        val recycler=view.findViewById<RecyclerView>(R.id.my_games_recycler)
        recycler.layoutManager=LinearLayoutManager(requireActivity())
        return view
    }
}