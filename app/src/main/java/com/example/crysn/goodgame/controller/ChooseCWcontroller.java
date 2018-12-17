package com.example.crysn.goodgame.controller;

import com.example.crysn.goodgame.model.Question;
import com.example.crysn.goodgame.model.Word;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class ChooseCWcontroller {

    Random random;
    //<editor-fold desc="Initialization">
    public ChooseCWcontroller() {
        random = new Random();
    }
    //</editor-fold>

    //<editor-fold desc="public interface">
    public ArrayList<Question> questions(){
        ArrayList<Question> questions= new ArrayList<>();
        for(int i = 0; i < 6; i++){
            Vector<String> words = RegistrationController.user.getWords();
            Vector<String> wrongWords = getWrongWords(words);
            /*if(words.equals(null) || wrongWords.equals(null)){
                return null;
            }*/
        Question question = new Question("Как переводится слово \""+words.get(0)+"\"?",
                words.get(1), words.get(1),wrongWords.get(0) ,wrongWords.get(1),wrongWords.get(2));
        questions.add(question);
        wrongWords = null;
        words = null;
        }
        return questions;
    }
    //</editor-fold>

    Vector<String> getWrongWords(Vector<String> words){
        /*if(RegistrationController.user.GetWordsArrayLength()<6){
            return null;
        }*/
        Vector<String> wrong;
        Vector<String> res = new Vector<>();
        int j=0;
        while(j<3) {
            wrong = RegistrationController.user.getWords();
            if (!wrong.equals(words)){
                res.add(wrong.get(1));
                j++;
            }
        }
        return res;
    }
}
