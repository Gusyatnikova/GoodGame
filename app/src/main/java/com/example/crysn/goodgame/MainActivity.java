package com.example.crysn.goodgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Called when the user taps the Send button */
    public void toTeacher(View view) {
        Intent intent = new Intent(this, TeacherMainMenu.class);
        startActivity(intent);
    }
    public void toStudent(View view) {
        Intent intent = new Intent(this, StudentMainMenu.class);
        startActivity(intent);
    }
}
