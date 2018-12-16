package com.example.crysn.goodgame.model;

public class User {
    private String login;
    private String pswd;
    private String firstName;
    private String lastName;
    private String registrator;

    public User() {
        this.login = null;
        this.lastName = null;
        this.firstName = null;
        this.pswd = null;
        this.registrator = null;
    }
    public User(String login, String pswd, String firstName, String lastName, String registrator) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pswd = pswd;
        this.registrator = registrator;
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
    public void setRegistrator(String registrator) {
        this.registrator = registrator;
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
    public String getRegistrator() {
        return registrator;
    }
}
