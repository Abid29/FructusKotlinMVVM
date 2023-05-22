package com.example.fructuskotlinmvvm.fragments

import FruitRepository
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.fructuskotlinmvvm.R
import com.example.fructuskotlinmvvm.model.Fruit

class viewPagerItemsFragment(private val fruitArrayList: ArrayList<Fruit>? , private val position: Int) : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_view_pager_items, container, false)

        var relativeLayout: RelativeLayout = view.findViewById(R.id.relativeLayout)
        var imageView: ImageView = view.findViewById(R.id.imageView)
        var title: TextView = view.findViewById(R.id.title)
        var headline: TextView = view.findViewById(R.id.headline)
        var button: TextView = view.findViewById(R.id.startButton)

        var fruit = fruitArrayList?.get(position)
        if (fruit != null) {
            title.text = fruit.title
            headline.text = fruit.headline

            val colors = intArrayOf(
                Color.parseColor(fruit.gradientColors.get(0)),
                Color.parseColor(fruit.gradientColors.get(1))
            )
            //create a new gradient color
            //create a new gradient color
            val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors)
            gd.cornerRadius = 0f

            relativeLayout.background = gd


            context?.let {
                Glide.with(it)
                    .asBitmap()
                    .load(getImage(fruit.image))
                    .into(imageView)
            }
        }
        return view
    }
    fun getImage(imageName: String?): Int? {
        return context?.getResources()?.getIdentifier(imageName, "drawable", context?.getPackageName())
    }
}