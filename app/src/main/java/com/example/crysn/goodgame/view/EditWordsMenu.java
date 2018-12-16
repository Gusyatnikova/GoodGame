package com.example.crysn.goodgame.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.crysn.goodgame.R;
import com.example.crysn.goodgame.controller.RegistrationController;
import com.example.crysn.goodgame.controller.WordListController;

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


        final ListView listView = (ListView) findViewById(R.id.listview);
        String[] values = new String[]{
                "Apple - яблоко", "Pear - груша",
                "Orange - апельсин", "Onion - лук", "Cucumber - огурец",
                "Apple - яблоко", "Pear - груша",
                "Orange - апельсин", "Onion - лук", "Cucumber - огурец",
                "Apple - яблоко", "Pear - груша",
                "Orange - апельсин", "Onion - лук", "Cucumber - огурец",
                "Apple - яблоко", "Pear - груша",
                "Orange - апельсин", "Onion - лук", "Cucumber - огурец"
        };
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }


        final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
//                final String item = (String)parent.getItemAtPosition(position);
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