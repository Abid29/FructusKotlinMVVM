package com.example.fructuskotlinmvvm.ui.screen.mainActivity.activity

import FruitRepository
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.fructuskotlinmvvm.R
import com.example.fructuskotlinmvvm.ui.screen.onBoarding.fragment.OnBoardingFragment
import com.example.fructuskotlinmvvm.data.model.Fruit
import com.example.fructuskotlinmvvm.ui.screen.Interface.Communicator
import com.example.fructuskotlinmvvm.ui.screen.itemListScreen.fragment.ItemListFragment

class MainActivity : AppCompatActivity() , Communicator{

    lateinit var fruitList : ArrayList<Fruit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fruitRepository : FruitRepository = FruitRepository()
        fruitList = fruitRepository.getAllFruits()!!
        val fragmentContainer = findViewById<FragmentContainerView>(R.id.fragmentContainer)
        val fragmentManager = supportFragmentManager

        val onBoardingFragment = OnBoardingFragment(fruitList)
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, onBoardingFragment).commit()
    }

    override fun OnBoardingFragmentToItemListFragment(){
        this.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,ItemListFragment(fruitList,this)).commit()
    }

}