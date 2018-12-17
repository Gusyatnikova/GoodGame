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


public class DeleteStudent extends AppCompatActivity {
    private RegistrationController controller;
    AlertDialog alert;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);
        controller = RegistrationMenu.controller;
        ArrayList<String> addedStudents = new ArrayList<>();
        addedStudents = controller.doSelect(RegistrationController.user.getFirstName(), RegistrationController.user.getLastName(), true);

        final ListView listView = (ListView) findViewById(R.id.studentlist);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, addedStudents);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Registration");
                builder.setMessage("Вы действительно хотите удалить пользователя?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        String item = ((TextView) view).getText().toString();
                        String[] arr = item.split(" ");
                        String log = arr[0] + "_" + arr[1];
                        controller.delete(arr[0], arr[1]);
                        RegistrationController.achievementsController.delete(arr[0],arr[1]);
                        dialog.dismiss();
                        Intent intent = new Intent(view.getContext(), DeleteStudent.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        dialog.dismiss();
                    }
                });

                alert = builder.create();
                alert.show();
            }
        });
    }
}
