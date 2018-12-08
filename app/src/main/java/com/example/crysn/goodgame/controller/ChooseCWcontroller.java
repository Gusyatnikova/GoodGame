package com.example.crysn.goodgame.controller;

import com.example.crysn.goodgame.model.Question;

import java.util.ArrayList;

public class ChooseCWcontroller {
    //<editor-fold desc="Initialization">
    public ChooseCWcontroller() {
    }
    //</editor-fold>

    //<editor-fold desc="public interface">
    public ArrayList<Question> questions(){
        Question question1 = new Question("Как переводится слово \"meet\"?",
                "Встречать", "Думать", "Предприниматель", "Встречать", "Вспоминать");
        Question question2 = new Question("Как переводится слово \"speed\"?",
                "Скорость", "Скорость", "Вербовать", "Боярин", "Багульник");
        Question question3 = new Question("Как переводится слово \"translator\"?",
                "Переводчик", "Перевести", "Переводчик", "Скорость", "Сила");
        Question question4 = new Question("Как переводится слово \"honor\"?",
                "Честь", "Совесть", "Благородство", "Честь", "Память");
        Question question5 = new Question("Как переводится слово \"think\"?",
                "Думать", "Думать", "Знать", "Дышать", "Хмуриться");
        Question question6 = new Question("Как переводится слово \"willow\"?",
                "Верба", "Деревня", "Волна", "Долг", "Верба");
        ArrayList<Question> questions= new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        return questions;
    }
    //</editor-fold>
}
