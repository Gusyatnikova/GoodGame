package com.example.crysn.goodgame.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.controller.RegistrationController;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class RegisterStudent extends AppCompatActivity {
    private RegistrationController controller;
    AlertDialog.Builder builder;
    AlertDialog alert;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);
        controller = RegistrationMenu.controller;
        Button bt = findViewById(R.id.button3);
        bt.setOnClickListener(onClickListener);
    }
    private View.OnClickListener onClickListener = (v) -> {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterStudent.this);
        AlertDialog alert = builder.create();
        EditText scFN = findViewById(R.id.firstName);
        EditText scLN = findViewById(R.id.lastName);
        String firstName = scFN.getText().toString();
        String lastName = scLN.getText().toString();

        String login = firstName + "_" + lastName;
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 1; i++) {
            int symbol = rand.nextInt(255);
            sb.append(new String(String.valueOf(symbol)));

            String log = login;
            String pswd = sb.toString();
            if(!log.equals("_")) {
                if (controller.validate(log, "insystem")) {
                    builder.setTitle("Registration");
                    builder.setMessage("Такой пользователь уже зарегистрирован!");
                    alert = builder.create();
                } else {
                    builder.setTitle("Registration");
                    builder.setMessage("Login: " + log + "\nPassword: " + pswd);
                    controller.doInsert(firstName, lastName, RegistrationController.user.getFirstName(), RegistrationController.user.getLastName(), log, pswd);
                    alert = builder.create();
                }
            } else {
                builder.setTitle("Registration");
                builder.setMessage("Пустое имя пользователя!");
                alert = builder.create();
            }
        alert.show();
        }
    };
}
