package com.example.fructuskotlinmvvm.ui.screen.onBoarding.fragment

import android.annotation.SuppressLint
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
import com.example.fructuskotlinmvvm.data.model.Fruit
import com.example.fructuskotlinmvvm.ui.screen.Interface.Communicator
import com.example.fructuskotlinmvvm.ui.screen.itemListScreen.fragment.ItemListFragment

class OnBoardingItemsFragment(private val fruit : Fruit) : Fragment() {

    private lateinit var communicator: Communicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_on_boarding_items, container, false)

        communicator = activity as Communicator

        var relativeLayout: RelativeLayout = view.findViewById(R.id.relativeLayout)
        var imageView: ImageView = view.findViewById(R.id.imageView)
        var title: TextView = view.findViewById(R.id.title)
        var headline: TextView = view.findViewById(R.id.headline)
        var button: TextView = view.findViewById(R.id.startButton)

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

        button.setOnClickListener{
            communicator.OnBoardingFragmentToItemListFragment()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    fun getImage(imageName: String?): Int? {
        return context?.getResources()?.getIdentifier(imageName, "drawable", context?.getPackageName())
    }
}