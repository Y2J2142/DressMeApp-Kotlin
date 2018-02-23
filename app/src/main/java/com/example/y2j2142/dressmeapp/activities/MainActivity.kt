package com.example.y2j2142.dressmeapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.y2j2142.dressmeapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onClick = OnClickListener { Toast.makeText(this, "Hi there! This is a Toast.", Toast.LENGTH_LONG).show() }
        val moveToWardrobe = OnClickListener({
            val intent = Intent(this, Wardrobe::class.java)
            startActivity(intent)
        })

        DressMeAppButton.setOnClickListener(null)
        WardrobeButton.setOnClickListener(moveToWardrobe)
    }


    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
