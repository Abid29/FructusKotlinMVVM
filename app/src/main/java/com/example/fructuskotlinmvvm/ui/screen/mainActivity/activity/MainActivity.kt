package com.example.fructuskotlinmvvm.ui.screen.mainActivity.activity

import FruitRepository
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.fructuskotlinmvvm.R
import com.example.fructuskotlinmvvm.ui.screen.onBoarding.fragment.OnBoardingFragment
import com.example.fructuskotlinmvvm.data.model.Fruit

class MainActivity : AppCompatActivity(){

    lateinit var fruitList : ArrayList<Fruit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fruitRepository : FruitRepository = FruitRepository()
        fruitList = fruitRepository.getAllFruits()!!
        val fragmentContainer = findNavController(R.id.fragmentContainer)
        val fragmentManager = supportFragmentManager

        val onBoardingFragment = OnBoardingFragment(fragmentContainer,fruitList)
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, onBoardingFragment).commit()
    }



}