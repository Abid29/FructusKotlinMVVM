package com.example.fructuskotlinmvvm.ui.screen.itemListScreen.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fructuskotlinmvvm.R
import com.example.fructuskotlinmvvm.data.model.Fruit

class ItemListAdapter(val fruitList : ArrayList<Fruit> , context : Context) :
    RecyclerView.Adapter<ItemListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemListAdapter.MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_of_fruits, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemListAdapter.MyViewHolder, position: Int) {
        val fruit: Fruit = fruitList.get(position)

        holder.heading.text = fruit.title
        holder.description.text = fruit.headline
        Glide.with(context)
            .asBitmap()
            .load(
                context.getResources()
                    .getIdentifier(fruit.image, "drawable", context.getPackageName())
            )
            .into(holder.imageView)


        val colors = intArrayOf(
            Color.parseColor(fruit.gradientColors.get(0)),
            Color.parseColor(fruit.gradientColors.get(1))
        )
        //create a new gradient color
        //create a new gradient color
        val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors)
        gd.cornerRadius = 0f

        holder.imageView.background = gd

    }

    override fun getItemCount(): Int = fruitList.size


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var heading: TextView = itemView.findViewById<TextView>(R.id.heading)
        var cardView: TextView? = itemView.findViewById<TextView>(R.id.crdvw)
        var description: TextView = itemView.findViewById<TextView>(R.id.desc)

    }

}