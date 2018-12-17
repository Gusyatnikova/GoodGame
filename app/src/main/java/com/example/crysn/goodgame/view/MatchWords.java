package com.example.crysn.goodgame.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.controller.MatchWcontroller;
import com.example.crysn.goodgame.model.Word;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MatchWords extends AppCompatActivity {
    private ListView english;
    private ListView russian;

    private String answer1;
    private String answer2;

    private ArrayList<Word> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_words);
        setupWords(this.getApplicationContext());
    }

    private void setupWords(final Context context) {
        english = findViewById(R.id.english);
        russian = findViewById(R.id.russian);
        answer1 = "";
        answer2 = "";
        MatchWcontroller controller = new MatchWcontroller();
        words = controller.words();

        final ArrayList<String> englishlist = new ArrayList<String>();

        for (int i = 0; i < words.size(); i++) {
            englishlist.add(words.get(i).getEnglishWord());
        }
        Collections.sort(englishlist);
        Collections.reverse(englishlist);
        final ArrayList<String> russianlist = new ArrayList<String>();

        for (int i = 0; i < words.size(); i++) {
            russianlist.add(words.get(i).getRussianWord());
        }
        Collections.sort(russianlist);
        Collections.reverse(russianlist);
        final StableArrayAdapter ruadapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, russianlist);
        final StableArrayAdapter enadapter = new StableArrayAdapter(context, android.R.layout.simple_list_item_1, englishlist);
        english.setAdapter(enadapter);
        russian.setAdapter(ruadapter);

        english.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                //final String item = (String) parent.getItemAtPosition(position);
                String item = ((TextView) view).getText().toString();

                if (answer1.equals("")){
                    answer1 = item; }
                else if (answer2.equals("")) {
                    answer2 = item;
                    for (int i = 0; i < words.size(); i++) {
                        String rus = words.get(i).getRussianWord();
                        String eng = words.get(i).getEnglishWord();
                        if (answer1.equals(rus)) {
                            if (answer2.equalsIgnoreCase(eng)) {
                                Toast.makeText(context, "Correct answer", Toast.LENGTH_SHORT).show();
                                enadapter.remove(answer2);
                                ruadapter.remove(answer1);
                            }
                        }
                        if(answer1.equals(eng)){
                            if(answer2.equalsIgnoreCase(rus)){
                                Toast.makeText(context, "Correct answer", Toast.LENGTH_SHORT).show();
                                enadapter.remove(answer1);
                                ruadapter.remove(answer2);
                            }
                        }
                    }
                    if(enadapter.isEmpty()){
                        Toast.makeText(context, "Game passed", Toast.LENGTH_SHORT).show();
                        Intent intent;
                        intent = new Intent(context, LevelsMenu.class);
                        startActivity(intent);
                    }
                    answer1 = "";
                    answer2 = "";
                }
//                view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        list.remove(item);
//                        adapter.notifyDataSetChanged();
//                        view.setAlpha(1);
//                    }
//                });
            }
        });
        russian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //final String item = (String) parent.getItemAtPosition(position);
                String item = ((TextView) view).getText().toString();
                if (answer1.equals(""))
                    answer1 = item;
                else if (answer2.equals("")) {
                    answer2 = item;
                    for (int i = 0; i < words.size(); i++) {
                        String rus = words.get(i).getRussianWord();
                        String eng = words.get(i).getEnglishWord();
                        if (answer1.equals(rus)) {
                            if (answer2.equals(eng)) {
                                Toast.makeText(context, "Correct answer", Toast.LENGTH_SHORT).show();
                                enadapter.remove(answer2);
                                ruadapter.remove(answer1);
                            }
                        }
                        if (answer1.equals(eng)) {
                            if (answer2.equals(rus)) {
                                Toast.makeText(context, "Correct answer", Toast.LENGTH_SHORT).show();
                                enadapter.remove(answer1);
                                ruadapter.remove(answer2);
                            }
                        }
                    }
                    if(enadapter.isEmpty()){
                        Toast.makeText(context, "Game passed", Toast.LENGTH_SHORT).show();
                        Intent intent;
                        intent = new Intent(context, LevelsMenu.class);
                        startActivity(intent);
                    }
                    answer1 = "";
                    answer2 = "";
                }
//                view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
//                    @Override
//                    public void run() {
//                        list.remove(item);
//                        adapter.notifyDataSetChanged();
//                        view.setAlpha(1);
//                    }
//                });
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
}
