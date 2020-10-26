package com.example.connect3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var activePlayer = 0

    fun dropIn(view: View) {

        var counter = view as ImageView

        counter.translationY = -1500f

        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.yellow)
        }
        else {
            counter.setImageResource(R.drawable.red)
        }
        activePlayer = (activePlayer + 1) % 2

        counter.animate().translationYBy(1500f).rotation(3600f).duration = 1000

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}