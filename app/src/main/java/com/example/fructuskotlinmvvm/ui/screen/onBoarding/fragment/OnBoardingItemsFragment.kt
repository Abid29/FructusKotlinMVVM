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
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.example.fructuskotlinmvvm.R
import com.example.fructuskotlinmvvm.data.model.Fruit

class OnBoardingItemsFragment(val navController: NavController,public final val fruitList:ArrayList<Fruit>,val position: Int) : Fragment() {

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

        var relativeLayout: RelativeLayout = view.findViewById(R.id.relativeLayout)
        var imageView: ImageView = view.findViewById(R.id.imageView)
        var title: TextView = view.findViewById(R.id.title)
        var headline: TextView = view.findViewById(R.id.headline)
        var button: TextView = view.findViewById(R.id.startButton)

        val fruit = fruitList[position]

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
            var bundle = Bundle()
            bundle.putParcelableArrayList("fruitList" , fruitList)


            val action = OnBoardingFragmentDirections.actionOnBoardingFragmentToItemListFragment()
            action.fruitList = bundle // Set the bundle in the action

            //findNavController().navigate(action) // Navigate to the destination

            navController.navigate(R.id.action_onBoardingFragment_to_itemListFragment)
        }

        return view
    }

    fun getImage(imageName: String?): Int? {
        return context?.getResources()?.getIdentifier(imageName, "drawable", context?.getPackageName())
    }
}

