package com.example.crysn.goodgame.controller;

import com.example.crysn.goodgame.model.Question;
import com.example.crysn.goodgame.model.Word;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class ChooseCWcontroller {
    private final Integer maxpoints = 6;
    private Integer currentPoint = 0;

    ArrayList<String> used;
    Random random;
    //<editor-fold desc="Initialization">
    public ChooseCWcontroller() {
        random = new Random();
        used = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="public interface">
    public ArrayList<Question> questions(){
        ArrayList<Question> questions= new ArrayList<>();
        for(int i = 0; i<6 ; i++){
            Vector<String> words = RegistrationController.user.getWords();
            Vector<String> wrongWords = getWrongWords(words);
            /*if(words.equals(null) || wrongWords.equals(null)){
                return null;
            }*/
            ArrayList<String> arr = new ArrayList<>();
            arr.add(words.get(1));
            arr.add(wrongWords.get(0));
            arr.add(wrongWords.get(1));
            arr.add(wrongWords.get(2));
        Question question = new Question("Как переводится слово \""+words.get(0)+"\"?",
                words.get(1), getRandom(arr),getRandom(arr) ,getRandom(arr),getRandom(arr));
        questions.add(question);
        wrongWords = null;
        words = null;
        }
        return questions;
    }
    //</editor-fold>

    public void addPoints(){
        this.currentPoint++;
    }

    public void saveStatistics(){
        RegistrationController.achievementsController.addPoints(currentPoint, maxpoints);
        currentPoint = 0;
    }

    Vector<String> getWrongWords(Vector<String> words){
        /*if(RegistrationController.user.GetWordsArrayLength()<6){
            return null;
        }*/
        Vector<String> wrong;
        Vector<String> res = new Vector<>();

        int j=0;
        while(j<3) {
            wrong = RegistrationController.user.getWords();
            if (!wrong.equals(words) && !res.contains(wrong.get(1))){
                res.add(wrong.get(1));
                j++;
            }
        }
        return res;
    }
    String getRandom(ArrayList<String> arr){
        int i =0;
        String str = "";
        while(i<1){
            int j = random.nextInt(4);
            str = arr.get(j);
            if(!used.contains(str)){
                used.add(str);
                i++;
            }
            if(used.size() == 4){
                used.clear();
            }
        }
        return str;
    }
}
