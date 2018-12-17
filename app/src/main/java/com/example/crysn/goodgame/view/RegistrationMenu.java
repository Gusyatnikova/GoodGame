package com.example.crysn.goodgame.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.controller.RegistrationController;


public class RegistrationMenu extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private EditText login;
    private EditText pswd;
    static RegistrationController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        login = findViewById(R.id.login);
        pswd = findViewById(R.id.pswd);
        controller = new RegistrationController(this.getApplicationContext());
        controller.doInsert("admin", "admin", "admin", "admin", "admin", "admin");
    }

    public void enter(View view) {
        String Login = login.getText().toString();
        String Pswd = pswd.getText().toString();

        boolean res = controller.validate(Login, Pswd);
        if(!res) {
            Toast.makeText(view.getContext(), "Wrong login or password", Toast.LENGTH_SHORT).show();
            login.setText("");
            pswd.setText("");
        }else{
            Intent intent = new Intent(this, SelectRoleMenu.class);
            startActivity(intent);
        }
    }
}
