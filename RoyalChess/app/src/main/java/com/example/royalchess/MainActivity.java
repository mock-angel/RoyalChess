package com.example.royalchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSinglePlayer(View v){
        startActivity(new Intent(this, SinglePlayerLobby.class));
    }

    public void onClickMultiPlayer(View v){
        startActivity(new Intent(this, MultiplayerLobby.class));
    }
}