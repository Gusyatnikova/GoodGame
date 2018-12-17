package com.example.crysn.goodgame.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.crysn.goodgame.R;

public class Rules extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rules);
        String rules = new String("1. Сопоставь слова" + "\n " +
                "Вы увидите 2 колонки слов: на русском и английском языках. " +
                "Ваша задача - найти перевод слов. Начать можно с любого слова!" +
                "\n\n 2. Выбери правильное слово\n Вы увидите одно слово на английском" +
                "языке и ниже 4 на русском. Ваша задача - выбрать из них перевод указанного на английском слова." +
                "\n\n 3. Переведи слово\n Вы увидете одно слово на русском языке и поле для ввода." +
                "Вам необходимо вписать в него корректный перевод русского слова. \n Желаем удачи!"

        );
        String rules1 = new String("1. Сопоставь слова");
        EditText editText = (EditText) findViewById(R.id.editText10);
        editText.setText(rules1);
        String rules2 = new String("Вы увидите 2 колонки слов: на русском и английском языках. ");
        EditText editText2 = (EditText) findViewById(R.id.editText11);
        editText2.setText(rules2, TextView.BufferType.EDITABLE);
        String rules3 = new String("Ваша задача - найти перевод слов. Начать можно с любого слова!");
        EditText editText3 = (EditText) findViewById(R.id.editText12);
        editText3.setText(rules3, TextView.BufferType.EDITABLE);
        String rules4 = new String("2. Выбери правильное слово");
        EditText editText4 = (EditText) findViewById(R.id.editText13);
        editText4.setText(rules4, TextView.BufferType.EDITABLE);
        String rules5 = new String("Вы увидите одно слово на английском языке и ниже 4 на русском.");
        EditText editText5 = (EditText) findViewById(R.id.editText14);
        editText5.setText(rules5, TextView.BufferType.EDITABLE);
        String rules6 = new String("Ваша задача - выбрать из них перевод указанного на английском слова.");
        EditText editText6 = (EditText) findViewById(R.id.editText15);
        editText6.setText(rules6, TextView.BufferType.EDITABLE);
        String rules7 = new String("3. Переведи слово");
        EditText editText7 = (EditText) findViewById(R.id.editText16);
        editText7.setText(rules7, TextView.BufferType.EDITABLE);
        String rules8 = new String("Вы увидете одно слово на русском языке и поле для ввода.");
        EditText editText8 = (EditText) findViewById(R.id.editText17);
        editText8.setText(rules8, TextView.BufferType.EDITABLE);
        String rules9 = new String("Вам необходимо вписать в него корректный перевод русского слова.");
        EditText editText9 = (EditText) findViewById(R.id.editText18);
        editText9.setText(rules9, TextView.BufferType.EDITABLE);
        String rules10 = new String("Желаем удачи!");
        EditText editText10 = (EditText) findViewById(R.id.editText19);
        editText10.setText(rules10, TextView.BufferType.EDITABLE);
    }
}
