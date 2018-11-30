package com.example.crysn.goodgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class RegistrationMenu extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    // Called when the user taps the Send button */
    //TODO: public void enter(String login, String pswd)
    public void enter(View view) {
        Intent intent = new Intent(this, SelectRoleMenu.class);
        startActivity(intent);
    }
}
