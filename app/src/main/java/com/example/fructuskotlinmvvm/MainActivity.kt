package com.example.fructuskotlinmvvm

import FruitRepository
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.fructuskotlinmvvm.fragments.ViewPagerFragment
import com.example.fructuskotlinmvvm.model.Fruit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fruitRepository : FruitRepository = FruitRepository()
        val fruitList : ArrayList<Fruit>? = fruitRepository.getAllFruits()
        val fragmentContainer = findViewById<FragmentContainerView>(R.id.fragmentContainer)
        val fragmentManager = supportFragmentManager

        val viewPagerFragment = ViewPagerFragment(fruitList)
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer , viewPagerFragment).commit()
    }
}