package com.example.crysn.goodgame.controller;

import com.example.crysn.goodgame.model.Word;

import java.util.ArrayList;

public class MatchWcontroller {

    public MatchWcontroller() {}

    public ArrayList<Word> words(){
        Word words1 = new Word("meet",
                "Встречать");
        Word words2 = new Word("speed",
                "Скорость");
        Word words3 = new Word("translator",
                "Переводчик");
        Word words4 = new Word("honor",
                "Честь");
        Word words5 = new Word("think",
                "Думать");
        Word words6 = new Word("willow",
                "Верба");
        ArrayList<Word> words= new ArrayList<>();
        words.add(words1);
        words.add(words2);
        words.add(words3);
        words.add(words4);
        words.add(words5);
        words.add(words6);
        return words;
    }
}
