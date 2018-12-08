package com.example.crysn.goodgame.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.view.LevelsMenu;

public class StudentMainMenu extends AppCompatActivity {
    Button toLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main_menu);
        toLevels = findViewById(R.id.levels);
        toLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), LevelsMenu.class);
                startActivity(intent);
            }
        });
    }
}
