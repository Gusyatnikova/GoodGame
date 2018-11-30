package com.example.crysn.goodgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LevelsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels_menu2);
    }

    public void pressLevel1(View view) {
        Intent intent = new Intent(this, GamesMenu.class);
        startActivity(intent);
    }

    public void pressLevel2(View view) {
        Intent intent = new Intent(this, GamesMenu.class);
        startActivity(intent);
    }

    public void pressLevel3(View view) {
        Intent intent = new Intent(this, GamesMenu.class);
        startActivity(intent);
    }
}
