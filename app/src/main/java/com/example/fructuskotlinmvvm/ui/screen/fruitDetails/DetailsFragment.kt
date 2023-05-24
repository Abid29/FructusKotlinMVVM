package com.example.fructuskotlinmvvm.ui.screen.fruitDetails

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.fructuskotlinmvvm.R
import com.example.fructuskotlinmvvm.data.model.Fruit

class DetailsFragment : Fragment() {

    lateinit var imageView: ImageView
    lateinit var firstLayout: ConstraintLayout
    lateinit var title: TextView
    lateinit var headline: TextView
    lateinit var learn: TextView
    lateinit var description: TextView
    lateinit var innerText: TextView
    lateinit var textButton: TextView
    lateinit var fruit: Fruit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_details, container, false)

        val colors = intArrayOf(
            Color.parseColor(fruit.gradientColors.get(0)),
            Color.parseColor(fruit.gradientColors.get(1))
        )

        val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors)

        firstLayout.background = gd

        context?.let {
            Glide.with(it)
                .asBitmap()
                .load(getImage(fruit.image))
                .into(imageView)
        }

        title.text = fruit.title
        title.setTextColor(Color.parseColor(fruit.gradientColors.get(1)))
        headline.text = fruit.headline
        learn.text = "LEARN MORE ABOUT " + fruit.title.uppercase()
        learn.setTextColor(Color.parseColor(fruit.gradientColors.get(0)))
        description.text = fruit.description
        innerText.setBackgroundColor(Color.parseColor("#B2BEB5"))

        //textButton.setOnClickListener {finish()}

        return view
    }


    fun getImage(imageName: String?): Int? {
        return context?.getResources()
            ?.getIdentifier(imageName, "drawable", context?.getPackageName())
    }
}



