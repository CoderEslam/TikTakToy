package com.doubleclick.tictaktoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.content.Intent
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView


class MainActivity : AppCompatActivity() {

    lateinit var lottieAnimationView:LottieAnimationView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun buClick(view: View) {

        val bu = view as Button
        var cell = 0
        when (view.id) {
            R.id.bu1 -> cell = 1
            R.id.bu2 -> cell = 2
            R.id.bu3 -> cell = 3
            R.id.bu4 -> cell = 4
            R.id.bu5 -> cell = 5
            R.id.bu6 -> cell = 6
            R.id.bu7 -> cell = 7
            R.id.bu8 -> cell = 8
            R.id.bu9 -> cell = 9
        }

        Log.e("Main", "" + cell)
        PlayGame(cell, bu)
//        view.setBackgroundResource(R.color.blue)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var ActivePlayer = 0

    fun PlayGame(cell: Int, butChoice: Button) {

        if (ActivePlayer == 1) {
            butChoice.text = "X"
            butChoice.setBackgroundResource(R.color.blue)
            player1.add(cell)
            ActivePlayer = 2
        } else {
            butChoice.text = "O"
            butChoice.setBackgroundResource(R.color.darkGreen)
            player2.add(cell)
            ActivePlayer = 1
        }
        // عشان امنع ان اي حد يضغط عليه تاني
        butChoice.isEnabled = false

        CheckWinner()

    }

    fun Reset(view: View) {
        player1.clear()
        player2.clear()
        val intent = Intent()
        intent.setClass(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun CheckWinner() {

        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        //cross 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        //cross 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner!=-1){
            if(winner==1){
               Toast.makeText(this,"Player 1 is winner ",Toast.LENGTH_LONG).show()
                lottieAnimationView.visibility = View.VISIBLE
            }else{
                Toast.makeText(this,"Player 2 is winner ",Toast.LENGTH_LONG).show()
                lottieAnimationView.visibility = View.VISIBLE
            }
        }
    }


}