package com.example.crysn.goodgame.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.controller.RegistrationController;

public class StudentAchievements extends AppCompatActivity {
    private ProgressBar bar;
    private TextView text;
    private TextView points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_achievements);
        configureView();
    }

    private void configureView(){
        bar = findViewById(R.id.student_progress_bar);
        text = findViewById(R.id.achievements);
        points = findViewById(R.id.question_number);

        int max = RegistrationController.user.getMax();
        int _points = RegistrationController.user.getPoints();
        bar.setMax(max);
        bar.setProgress(_points);
        String currentProgressNumber = (_points)+"/"+max;
        points.setText(currentProgressNumber);
    }
}
