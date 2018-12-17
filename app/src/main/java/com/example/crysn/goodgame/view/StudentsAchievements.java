package com.example.crysn.goodgame.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.controller.RegistrationController;
import com.example.crysn.goodgame.model.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;


public class StudentsAchievements extends AppCompatActivity {
    private RegistrationController controller;
    AlertDialog alert;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_achievements);
        controller = RegistrationMenu.controller;
        ArrayList<String> currentStudents = new ArrayList<>();
        currentStudents = controller.doSelect(RegistrationController.user.getFirstName(), RegistrationController.user.getLastName(), true);
        for(int i = 0 ; i < currentStudents.size(); i++) {
           Vector<Integer> cur_ach = RegistrationController.achievementsController.getStudentsPoints(currentStudents.get(i).split(" ")[0], currentStudents.get(i).split(" ")[1]);
           currentStudents.add(i, currentStudents.get(i).split(" ")[0] + " " + currentStudents.get(i).split(" ")[1] + " cur: "
                   + String.valueOf(cur_ach.get(0)) + " max: " + String.valueOf(cur_ach.get(1)));
        }
        final ListView listView = (ListView) findViewById(R.id.studenslistview);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, currentStudents);
        listView.setAdapter(adapter);
    }
}
