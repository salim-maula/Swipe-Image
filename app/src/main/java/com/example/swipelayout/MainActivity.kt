package com.example.swipelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var actionBar: ActionBar

    private lateinit var myModelArrayList: ArrayList<MyModel>
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar = this.supportActionBar!!
        loadCard()

        //add page change listener
        viewPager.addOnPageChangeListener(object  :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    private fun loadCard() {
        //init list
        myModelArrayList = ArrayList()

        //add item to array list
        myModelArrayList.add(MyModel(R.drawable.back1))
        myModelArrayList.add(MyModel(R.drawable.back2))
        myModelArrayList.add(MyModel(R.drawable.back3))
        myModelArrayList.add(MyModel(R.drawable.back4))

        //set up adapter
        myAdapter = MyAdapter(this, myModelArrayList)

        //set adapter to viewpager
        viewPager.adapter = myAdapter

        //set default padding
        viewPager.setPadding(150,0,150,0)
    }
}