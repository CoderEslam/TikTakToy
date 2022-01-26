package com.doubleclick.tictaktoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.content.Intent




class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun buClick(view: View) {

        val bu = view as Button
        var cell = 0
        when(view.id){
            R.id.bu1->cell = 1
            R.id.bu2->cell = 2
            R.id.bu3->cell = 3
            R.id.bu4->cell = 4
            R.id.bu5->cell = 5
            R.id.bu6->cell = 6
            R.id.bu7->cell = 7
            R.id.bu8->cell = 8
            R.id.bu9->cell = 9
        }

        Log.e("Main",""+cell)
        PlayGame(cell,bu)
//        view.setBackgroundResource(R.color.blue)
    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var ActivePlayer = 0

    fun PlayGame(cell:Int,butChoice:Button){

        if (ActivePlayer==1){
            butChoice.text = "X"
            butChoice.setBackgroundResource(R.color.blue)
            player1.add(cell)
            ActivePlayer = 2
        }else{
            butChoice.text = "O"
            butChoice.setBackgroundResource(R.color.darkGreen)
            player2.add(cell)
            ActivePlayer = 1
        }
        // عشان امنع ان اي حد يضغط عليه تاني
        butChoice.isEnabled = false
    }

    fun Reset(view:View) {
        player1.clear()
        player2.clear()
        val intent = Intent()
        intent.setClass(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}