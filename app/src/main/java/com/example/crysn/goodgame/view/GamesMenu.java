package com.example.crysn.goodgame.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.crysn.goodgame.R;

public class GamesMenu extends AppCompatActivity {
    Button toChooseCW;
    Button toTranslateWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_menu);
        toChooseCW = findViewById(R.id.level1);
        toChooseCW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), ChooseCorrectWord.class);
                startActivity(intent);
            }
        });
        toTranslateWord = findViewById(R.id.level2);
        toTranslateWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), TranslateWord.class);
                startActivity(intent);
            }
        });
    }

}
