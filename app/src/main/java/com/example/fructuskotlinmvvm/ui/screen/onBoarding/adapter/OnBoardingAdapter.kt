package com.example.fructuskotlinmvvm.ui.screen.onBoarding.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fructuskotlinmvvm.ui.screen.onBoarding.fragment.OnBoardingItemsFragment
import com.example.fructuskotlinmvvm.data.model.Fruit

class onBoardingAdapter(private val fruitList: ArrayList<Fruit>, fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = fruitList.size

    override fun createFragment(position: Int): Fragment {
        return OnBoardingItemsFragment(fruitList[position])

//        val fragment = viewPagerItemsFragment()
//        val args = Bundle()
//        args.putFruit("fruit", fruitList[position])
//        fragment.arguments = args
//        return fragment

    }
}