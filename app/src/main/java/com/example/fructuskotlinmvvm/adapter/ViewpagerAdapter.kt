package com.example.fructuskotlinmvvm.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fructuskotlinmvvm.fragments.viewPagerItemsFragment
import com.example.fructuskotlinmvvm.model.Fruit

class ViewpagerAdapter(private val fruitList: ArrayList<Fruit>) : FragmentStateAdapter(Fragment()) {

    override fun getItemCount(): Int = fruitList.size

    override fun createFragment(position: Int): Fragment {
        return viewPagerItemsFragment(fruitList,position)
    }
}