package com.example.crysn.goodgame.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.controller.Question;
import com.example.crysn.goodgame.controller.QuestionsManager;

import java.util.ArrayList;

public class ChooseCorrectWord extends AppCompatActivity {
    private ProgressBar progressbar;
    private TextView questionProgressNumber;
    private TextView CurrentQuestionTitle;
    private TextView questionText;
    private RadioGroup radiogroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextbutton;

    private int currentQuestionIndex = -1;
    private Question currentQuestion;
    private ArrayList<Question> questions;
    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_correct_word);
        setupQuestions();
        configureView();

        showNextQuestion(this.getApplicationContext());
    }
    //<editor-fold desc="Configuration">
    private void setupQuestions(){
        QuestionsManager questionsManager = new QuestionsManager();
        questions = questionsManager.questions();
    }
    private void configureView(){
        progressbar = findViewById(R.id.progress_bar);
        progressbar.setMax(questions.size());
        questionProgressNumber = findViewById(R.id.question_number);
        CurrentQuestionTitle = findViewById(R.id.current_question_title);
        questionText = findViewById(R.id.question_text);

        radiogroup = findViewById(R.id.rb_group);
        radiogroup.setOnCheckedChangeListener(onCheckedChangeListener);

        option1 = findViewById(R.id.rb_button1);
        option2 = findViewById(R.id.rb_button2);
        option3 = findViewById(R.id.rb_button3);
        option4 = findViewById(R.id.rb_button4);

        nextbutton = findViewById(R.id.button_next);
        nextbutton.setOnClickListener(onNextButtonClickListener);
    }
    //</editor-fold>

    //<editor-fold desc="Private outlets listeners">
    private View.OnClickListener onNextButtonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button_next:
                    if(answer.equalsIgnoreCase(currentQuestion.getCorrect_answer()))
                        Toast.makeText(v.getContext(),"correct answer",Toast.LENGTH_SHORT).show();
                    showNextQuestion(v.getContext());
                    break;
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_button1:
                    answer = option1.getText().toString();
                    break;
                case R.id.rb_button2:
                    answer = option2.getText().toString();
                    break;
                case R.id.rb_button3:
                    answer = option3.getText().toString();
                    break;
                case R.id.rb_button4:
                    answer = option4.getText().toString();
                    break;
                default:
                    answer = "";
            }
        }
    };
    //</editor-fold>

    private void showNextQuestion(Context context){
        if(++currentQuestionIndex < questions.size()){
            currentQuestion = questions.get(currentQuestionIndex);
            progressbar.setProgress(currentQuestionIndex+1);

            String currentProgressNumber = (currentQuestionIndex+1)+"/"+questions.size();
            questionProgressNumber.setText(currentProgressNumber);

            String currentQuestionTitle = "№" + (currentQuestionIndex+1);
            CurrentQuestionTitle.setText(currentQuestionTitle);

            questionText.setText(currentQuestion.getQuestion_text());

            radiogroup.clearCheck();

            option1.setText(currentQuestion.getOption1());
            option2.setText(currentQuestion.getOption2());
            option3.setText(currentQuestion.getOption3());
            option4.setText(currentQuestion.getOption4());
        }else{
            Toast.makeText(context,"Game passed",Toast.LENGTH_SHORT).show();
        }
    }
}
