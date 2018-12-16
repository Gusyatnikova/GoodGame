package com.example.crysn.goodgame.controller;

import com.example.crysn.goodgame.model.Question;

import java.util.ArrayList;

public class TranslateWcontroller {
    public TranslateWcontroller() {
    }

    public ArrayList<Question> questions(){
        Question question1 = new Question("Как переводится слово \"meet\"?",
                "Встречать");
        Question question2 = new Question("Как переводится слово \"speed\"?",
                "Скорость");
        Question question3 = new Question("Как переводится слово \"translator\"?",
                "Переводчик");
        Question question4 = new Question("Как переводится слово \"honor\"?",
                "Честь");
        Question question5 = new Question("Как переводится слово \"think\"?",
                "Думать");
        Question question6 = new Question("Как переводится слово \"willow\"?",
                "Верба");
        ArrayList<Question> questions= new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        return questions;
    }
}
