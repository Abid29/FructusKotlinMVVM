package com.example.fructuskotlinmvvm.ui.screen.onBoarding.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.fructuskotlinmvvm.R
import com.example.fructuskotlinmvvm.ui.screen.onBoarding.adapter.onBoardingAdapter
import com.example.fructuskotlinmvvm.data.model.Fruit

class OnBoardingFragment(val fruitList: ArrayList<Fruit>?) : Fragment() {

    private lateinit var viewpager2 : ViewPager2
    private lateinit var adapter: onBoardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_on_boarding, container, false)

        viewpager2 = view.findViewById<ViewPager2>(R.id.viewpager2)
        adapter = fruitList?.let { onBoardingAdapter(it,requireActivity()) }!!
        viewpager2.adapter = adapter

        return view
    }



}