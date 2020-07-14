package com.example.royalchess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.royalchess.Pieces.GameBoard

class OfflineMultiplayerGame : AppCompatActivity() {

    val board = GameBoard()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline_multiplayer_game)
    }

    public fun onClickSquare(v: View){
        v.context.
    }
}