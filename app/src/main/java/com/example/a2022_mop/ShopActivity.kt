package com.example.a2022_mop

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class ShopActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        var gridView = findViewById<View>(R.id.shopGrid) as GridView
        var gridAdapter = GridAdapter(this)
        gridView.adapter = gridAdapter
    }

    inner class GridAdapter(var context: Context) : BaseAdapter() {
        override fun getCount(): Int {
            TODO("Not yet implemented")
        }

        override fun getItem(p0: Int): Any {
            TODO("Not yet implemented")
        }

        override fun getItemId(p0: Int): Long {
            TODO("Not yet implemented")
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            TODO("Not yet implemented")
        }
    }
}