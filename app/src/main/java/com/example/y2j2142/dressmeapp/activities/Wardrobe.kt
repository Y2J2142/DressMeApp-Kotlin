package com.example.y2j2142.dressmeapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.y2j2142.dressmeapp.R
import com.example.y2j2142.dressmeapp.adapters.WardrobeClothingAdapter
import com.example.y2j2142.dressmeapp.model.Clothing
import com.example.y2j2142.dressmeapp.model.Tag
import kotlinx.android.synthetic.main.activity_wardrobe.*

class Wardrobe : AppCompatActivity() {
    val tag1 = Tag(name = "tag1")
    val tag2 = Tag(name = "tag2")
    val tag3 = Tag(name = "tag3")
    val cloth1 = Clothing(mutableListOf(tag1),"tshitrt", "koszulek")
    val cloth2 = Clothing(mutableListOf(tag2), "trousers", "spodnie")
    val cloth3 = Clothing(mutableListOf(tag3), "shoes", "buty")
    val list = mutableListOf(cloth1, cloth2, cloth3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wardrobe)
        val adapter = WardrobeClothingAdapter(this, list)
        WardrobeListView.adapter = adapter
    }


    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
