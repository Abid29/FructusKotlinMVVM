package com.example.fructuskotlinmvvm.ui.screen.itemListScreen.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fructuskotlinmvvm.R
import com.example.fructuskotlinmvvm.data.model.Fruit
import com.example.fructuskotlinmvvm.ui.screen.itemListScreen.adapter.ItemListAdapter

class ItemListFragment(private val fruitList : ArrayList<Fruit>, context : Context) : Fragment() {

    lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        recyclerView = view.findViewById(R.id.recView)
        recyclerView.adapter = context?.let { ItemListAdapter(fruitList , it) }

        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

}