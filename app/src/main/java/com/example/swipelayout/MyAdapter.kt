package com.example.swipelayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.card_item.view.*

class MyAdapter(private val context: Context, private val myModeArrayList: ArrayList<MyModel>) : PagerAdapter() {

    override fun getCount(): Int {
        return myModeArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view : View = LayoutInflater.from(container.context).inflate(R.layout.card_item, container, false)

        // get data
        val model = myModeArrayList[position]
        val image = model.image

        // set data
        view.bannerId.setImageResource(image)

        view.setOnClickListener {
            Toast.makeText(context, "Item Clicked", Toast.LENGTH_LONG).show()
        }

        //add view to container
        container.addView(view, position)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}