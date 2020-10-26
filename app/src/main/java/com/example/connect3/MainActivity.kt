package com.example.connect3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.connect3.R.drawable.yellow

class MainActivity : AppCompatActivity() {

    fun dropIn(view: View) {

        var counter = view as ImageView

        counter.translationY = -1500f
        counter.setImageResource(yellow)
        counter.animate().translationYBy(1500f).rotation(3600f).duration = 1000

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}