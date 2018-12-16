package com.example.crysn.goodgame.model;

import java.util.ArrayList;

public class User {
    private String login;
    private String pswd;
    private String firstName;
    private String lastName;
    private String registratorFirstName;
    private String registratorLastName;
    private ArrayList<Word> studentWords;

    public User() {
        this.login = null;
        this.lastName = null;
        this.firstName = null;
        this.pswd = null;
        this.registratorFirstName = null;
        this.registratorLastName = null;
        this.studentWords = null;
    }
    public User(String login, String pswd, String firstName, String lastName, String registratorFirstName, String registratorLastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pswd = pswd;
        this.registratorFirstName = registratorFirstName;
        this.registratorLastName = registratorLastName;
        this.studentWords = new ArrayList<Word>();
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setRegistrator(String registratorFirstName, String registratorLastName) {
        this.registratorFirstName = registratorFirstName;
        this.registratorLastName = registratorLastName;
    }
    public String getLogin() {
        return this.login;
    }

    public String getPswd() {
        return pswd;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getRegistratorFirstName() {
        return registratorFirstName;
    }

    public String getRegistratorLastName() {
        return registratorLastName;
    }

    public void setWords(ArrayList<Word> words){
        this.studentWords = words;
    }
}
