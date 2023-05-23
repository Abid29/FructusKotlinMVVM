package com.example.fructuskotlinmvvm.data.model

data class Fruit(
    val id:Int, val title:String, val headline:String, val image:String, val description:String,
    val gradientColors: ArrayList<String?>, val nutritions: ArrayList<String?>
)
