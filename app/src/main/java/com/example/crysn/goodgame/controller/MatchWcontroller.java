package com.example.crysn.goodgame.controller;

import com.example.crysn.goodgame.model.Word;

import java.util.ArrayList;
import java.util.Vector;

public class MatchWcontroller {

    private final Integer maxpoints = 6;
    private Integer currentPoint = 0;

    public MatchWcontroller() {}

    public ArrayList<Word> words(){
        ArrayList<Word> words= new ArrayList<>();
        Vector<String> res = new Vector<>();
        int i = 0;
        while(i<6){
            Vector<String> _words = RegistrationController.user.getWords();
            if(!res.contains(_words.get(0))){
                Word words1 = new Word(_words.get(0), _words.get(1));
                words.add(words1);
                res.add(_words.get(0));
                res.add(_words.get(1));
                i++;
            }
        }
        return words;
    }

    public void addPoints(){
        this.currentPoint++;
    }

    public void saveStatistics(){
        RegistrationController.achievementsController.addPoints(currentPoint, maxpoints);
        currentPoint = 0;
    }
}
