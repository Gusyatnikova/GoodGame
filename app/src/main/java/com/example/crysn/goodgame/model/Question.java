package com.example.crysn.goodgame.model;

import java.util.UUID;

public class Question {
    //<editor-fold desc="Private properties">
    private final UUID uuid;
    private final String Question_text;
    private final String Correct_answer;

    private final String option1;
    private final String option2;
    private final String option3;
    private final String option4;
    //</editor-fold>


    //<editor-fold desc="Initialization">
    public Question(String question_text, String correct_answer, String option1, String option2, String option3, String option4) {
        this.uuid = UUID.randomUUID();
        Question_text = question_text;
        Correct_answer = correct_answer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public Question(String question_text, String correct_answer) {
        this.uuid = UUID.randomUUID();
        Question_text = question_text;
        Correct_answer = correct_answer;
        this.option1 = "";
        this.option2 = "";
        this.option3 = "";
        this.option4 = "";
    }

    //</editor-fold>

    //<editor-fold desc="Getters">
    public UUID getUuid() {
        return uuid;
    }

    public String getQuestion_text() {
        return Question_text;
    }

    public String getCorrect_answer() {
        return Correct_answer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }
    //</editor-fold>
}
