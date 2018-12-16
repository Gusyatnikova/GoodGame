package com.example.crysn.goodgame.model;

import java.util.ArrayList;

public class WordsStorage {
    private ArrayList<Word> teachersWords;

    public WordsStorage() {
        this.teachersWords = new ArrayList<Word>();
    }
    public WordsStorage(ArrayList<Word>  words) {
        this.teachersWords = words;
    }
    public void addWord(Word newWord) {
        teachersWords.add(newWord);
    }
    public ArrayList<Word> getTeahersWords() {
        return this.teachersWords;
    }
}
