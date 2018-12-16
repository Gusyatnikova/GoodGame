package com.example.crysn.goodgame.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.controller.RegistrationController;
import com.example.crysn.goodgame.controller.WordListController;
import com.example.crysn.goodgame.model.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EditWordsMenu extends AppCompatActivity {
    private WordListController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_words);
        controller = new WordListController(this.getApplicationContext());

        ArrayList<Word> teachersWords = new ArrayList<>();
        teachersWords = controller.getWordsByTeacher(RegistrationController.user.getFirstName(), RegistrationController.user.getLastName());

        final ListView listView = (ListView) findViewById(R.id.listview);

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < teachersWords.size(); i++) {
            list.add(teachersWords.get(i).getEnglishWord() + "  -  " + teachersWords.get(i).getRussianWord());
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Confirm");
                builder.setMessage("Are you want delete this pair?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        String item = ((TextView) view).getText().toString();
                        String[] arr = item.split(" ");
                        controller.delete(arr[0], arr[4]);
                        dialog.dismiss();
                        Intent intent = new Intent(view.getContext(), EditWordsMenu.class);
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

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {
        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

    public void insertPair(View view) {
        EditText englishText = findViewById(R.id.editText);
        EditText russianText = findViewById(R.id.editText3);
        if (englishText.getText().toString().equals("") || russianText.getText().toString().equals("")) {
            Toast.makeText(view.getContext(), "Некорректный ввод!", Toast.LENGTH_SHORT).show();
        } else {
            controller.doInsert(englishText.getText().toString(), russianText.getText().toString());
            Toast.makeText(view.getContext(), "Пара слов успешно добавлена!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(view.getContext(), this.getClass());
            startActivity(intent);
        }
    }
}

