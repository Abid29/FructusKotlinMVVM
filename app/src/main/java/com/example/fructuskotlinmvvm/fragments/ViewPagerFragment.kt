package com.example.fructuskotlinmvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.fructuskotlinmvvm.R
import com.example.fructuskotlinmvvm.adapter.ViewpagerAdapter
import com.example.fructuskotlinmvvm.model.Fruit

class ViewPagerFragment(val fruitList: ArrayList<Fruit>?) : Fragment() {

    private lateinit var viewpager2 : ViewPager2
    private lateinit var adapter: ViewpagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_view_pager, container, false)

        viewpager2 = view.findViewById<ViewPager2>(R.id.viewpager2)
        adapter = fruitList?.let { ViewpagerAdapter(it) }!!
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewpager2.adapter = adapter

    }

}