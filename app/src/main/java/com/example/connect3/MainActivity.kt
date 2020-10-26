package com.example.connect3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

enum class BoardStates {
    EMPTY,
    PLAYER_0,
    PLAYER_1
}

class MainActivity : AppCompatActivity() {

    var boardState = Array(9){BoardStates.EMPTY}

    val winningPositions = arrayOf(
        arrayOf(0,1,2),
        arrayOf(3,4,5),
        arrayOf(6,7,8),
        arrayOf(0,3,6),
        arrayOf(1,4,7),
        arrayOf(2,5,8),
        arrayOf(0,4,8),
        arrayOf(2,4,6)
    )

    var activePlayer = BoardStates.PLAYER_0

    var gameIsActive = true

    fun dropIn(view: View) {

        var counter = view as ImageView

        val tappedCounter = counter.tag.toString().toInt()

        if (boardState[tappedCounter] == BoardStates.EMPTY && gameIsActive) {

            boardState[tappedCounter] = activePlayer

            counter.translationY = -1500f

            if (activePlayer == BoardStates.PLAYER_0) {
                counter.setImageResource(R.drawable.yellow)
                activePlayer = BoardStates.PLAYER_1
            } else {
                counter.setImageResource(R.drawable.red)
                activePlayer = BoardStates.PLAYER_0
            }

            counter.animate().translationYBy(1500f).rotation(3600f).duration = 1000

            for (winningPosition in winningPositions) {

                if (boardState[winningPosition[0]] == boardState[winningPosition[1]]
                    && boardState[winningPosition[1]] == boardState[winningPosition[2]]
                    && boardState[winningPosition[0]] != BoardStates.EMPTY
                ) {

                    gameIsActive = false

                    val winner = if (boardState[winningPosition[0]] == BoardStates.PLAYER_0) {
                        "Yellow"
                    } else {
                        "Red"
                    }

                    Toast.makeText(this, "$winner Won!", Toast.LENGTH_SHORT).show()

                }
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}