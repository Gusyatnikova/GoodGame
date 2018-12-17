package com.example.crysn.goodgame.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.controller.ChooseCWcontroller;
import com.example.crysn.goodgame.controller.TranslateWcontroller;
import com.example.crysn.goodgame.model.Question;

import java.util.ArrayList;

public class TranslateWord extends AppCompatActivity {
    private ProgressBar progressbar;
    private TextView questionProgressNumber;
    private TextView CurrentQuestionTitle;
    private TextView questionText;
    private EditText translation;
    private Button nextbutton;

    private int currentQuestionIndex = -1;
    private Question currentQuestion;
    private ArrayList<Question> questions;
    private String answer = "";

    TranslateWcontroller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_word);
        controller = new TranslateWcontroller();
        setupQuestions();
        configureView();

        showNextQuestion(this.getApplicationContext());
    }

    private void setupQuestions() {
        questions = controller.questions();
    }

    private void configureView() {
        progressbar = findViewById(R.id.progress_bar);
        progressbar.setMax(questions.size());
        questionProgressNumber = findViewById(R.id.question_number);
        CurrentQuestionTitle = findViewById(R.id.current_question_title);
        questionText = findViewById(R.id.question_text);
        translation = findViewById(R.id.translation);

        nextbutton = findViewById(R.id.button_next);
        nextbutton.setOnClickListener(onNextButtonClickListener);
    }

    //<editor-fold desc="Private outlets listeners">
    private View.OnClickListener onNextButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_next:
                    answer = translation.getText().toString();
                    if (answer.equals("")) {
                        Toast.makeText(v.getContext(), "Введите перевод слова", Toast.LENGTH_SHORT).show();
                    }
                    if (answer.equalsIgnoreCase(currentQuestion.getCorrect_answer())) {
                        Toast.makeText(v.getContext(), "correct answer", Toast.LENGTH_SHORT).show();
                        controller.addPoints();
                    }
                    translation.setText("");
                    showNextQuestion(v.getContext());
                    break;
            }
        }
    };

    private void showNextQuestion(Context context) {
        if (++currentQuestionIndex < questions.size()) {
            currentQuestion = questions.get(currentQuestionIndex);
            progressbar.setProgress(currentQuestionIndex + 1);

            String currentProgressNumber = (currentQuestionIndex + 1) + "/" + questions.size();
            questionProgressNumber.setText(currentProgressNumber);

            String currentQuestionTitle = "№" + (currentQuestionIndex + 1);
            CurrentQuestionTitle.setText(currentQuestionTitle);

            questionText.setText(currentQuestion.getQuestion_text());
            translation.setText("");
        } else {
            Toast.makeText(context, "Game passed", Toast.LENGTH_SHORT).show();
            controller.saveStatistics();
            Intent intent;
            intent = new Intent(context, LevelsMenu.class);
            startActivity(intent);
        }
    }
}
