package com.example.crysn.goodgame.model;

import java.util.UUID;
import java.util.Vector;

public class Word {
    private UUID uuid;
    private String EnglishWord;
    private String RussianWord;

    public Word(String englishWord, String russianWord) {
        this.uuid = UUID.randomUUID();
        EnglishWord = englishWord;
        RussianWord = russianWord;
    }

    public String getEnglishWord() {
        return EnglishWord;
    }

    public String getRussianWord() {
        return RussianWord;
    }

    public Vector<String> getPair(){
        Vector<String> vector = new Vector<>();
        vector.add(this.EnglishWord);
        vector.add(this.RussianWord);
        return vector;
    }

    public UUID getUuid() {
        return uuid;
    }
}
