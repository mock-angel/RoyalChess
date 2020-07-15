package com.example.royalchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MultiplayerLobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_lobby);
    }

    public void onClickOfflineMultiPlayer(View v){
        startActivity(new Intent(this, OfflineMultiPlayerGame.class));
    }
}