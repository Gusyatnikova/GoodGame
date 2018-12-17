package com.example.crysn.goodgame.controller;

import com.example.crysn.goodgame.model.Question;

import java.util.ArrayList;
import java.util.Vector;

public class TranslateWcontroller {

    private final Integer maxpoints = 6;
    private Integer currentPoint = 0;

    public TranslateWcontroller() {
    }

    public ArrayList<Question> questions() {
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Vector<String> words = RegistrationController.user.getWords();
            Question question = new Question("Как переводится слово \""+words.get(0)+"\"?",
                    words.get(1));
            questions.add(question);
        }
        return questions;
    }

    public void addPoints(){
        this.currentPoint++;
    }

    public void saveStatistics(){
        RegistrationController.achievementsController.addPoints(currentPoint, maxpoints);
        currentPoint = 0;
    }
}
