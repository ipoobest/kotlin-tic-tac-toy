package com.android.orc.tictactoygame

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    protected fun buClick(view: View) {
        val buSelected = view as Button
        var cellId = 0
        when (buSelected.id) {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }

//        Toast.makeText(this,"id : $cellId ", Toast.LENGTH_SHORT).show()
        playGame(cellId, buSelected)
        checkWin()

    }

    fun playGame(cellID: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "x"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()


        } else {
            buSelected.text = "o"
            buSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellID)

            activePlayer = 1

        }

        buSelected.isEnabled = false


    }

    fun checkWin() {
        var winner = -1


        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        //row3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }


        //col3
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        //col3
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, " Play 1 win !!!! ", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, " Play 2 win !!!! ", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun autoPlay() {
        var empyCells = ArrayList<Int>()

        for (cellID in 1..9) {

            if (!(player1.contains(cellID) || player2.contains(cellID))) {
                empyCells.add(cellID)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(empyCells.size - 0) + 0

        val cellId = empyCells[randIndex]

        var btnSelect: Button?
        when (cellId) {

            1 -> btnSelect = bu1
            2 -> btnSelect = bu2
            3 -> btnSelect = bu3
            4 -> btnSelect = bu4
            5 -> btnSelect = bu5
            6 -> btnSelect = bu6
            7 -> btnSelect = bu7
            8 -> btnSelect = bu8
            9 -> btnSelect = bu9
            else ->{
                btnSelect = bu1
            }
        }
        playGame(cellId, btnSelect)
    }

}
