package com.example.crysn.goodgame.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.crysn.goodgame.model.AuthorizationContract.AuthorizationEntry;
import com.example.crysn.goodgame.model.User;
import com.example.crysn.goodgame.model.WordsListContract;

public class WordListController {

    private WordsListDataBaseHelper dataBaseHelper;
    private User user;

    public WordListController(Context context){
        dataBaseHelper = new WordsListDataBaseHelper(context);
        this.user = RegistrationController.user;
    }

    public boolean validate(String teacherFirstName, String teacherLastName, String englishWord, String russianWord){
        if(englishWord.isEmpty() || russianWord.isEmpty())
            return false;
        else{
            boolean isIn = doSelect(teacherFirstName, teacherLastName, englishWord, russianWord);
            if (isIn)
                return false;
            else return true;
        }
    }

    private boolean doSelect(String teacherFirstName, String teacherLastName ,String englishWord, String russianWord){
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        String[] projection = {
                WordsListContract.WordsListEntry.COLUMN_TEACHER_LAST_NAME,
                WordsListContract.WordsListEntry.COLUMN_TEACHER_FIRST_NAME,
                WordsListContract.WordsListEntry.COLUMN_RUSSIAN_WORD,
                WordsListContract.WordsListEntry.COLUMN_ENGLISH_WORD};
        String selection = WordsListContract.WordsListEntry.COLUMN_TEACHER_FIRST_NAME + "=? AND " + WordsListContract.WordsListEntry.COLUMN_TEACHER_LAST_NAME + "=?" + WordsListContract.WordsListEntry.COLUMN_ENGLISH_WORD + "=? AND " + WordsListContract.WordsListEntry.COLUMN_RUSSIAN_WORD + "=?";
        String[] selectionArgs = {teacherFirstName, teacherLastName, englishWord, russianWord};
        Cursor cursor = db.query(
                AuthorizationEntry.TABLE_NAME, // таблица
                projection,            // столбцы
                selection,             // столбцы для условия WHERE
                selectionArgs,         // значения для условия WHERE
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                AuthorizationEntry.COLUMN_NAME + " DESC");  // порядок сортировки
        try {
            while (cursor.moveToNext()) {
                String currentFirstName = cursor.getString(cursor.getColumnIndex(WordsListContract.WordsListEntry.COLUMN_TEACHER_FIRST_NAME));
                String currentLastName = cursor.getString(cursor.getColumnIndex(WordsListContract.WordsListEntry.COLUMN_TEACHER_LAST_NAME));
                String currentEnglshWord = cursor.getString(cursor.getColumnIndex(WordsListContract.WordsListEntry.COLUMN_ENGLISH_WORD));
                String currentRussianWord = cursor.getString(cursor.getColumnIndex(WordsListContract.WordsListEntry.COLUMN_RUSSIAN_WORD));
                if(currentFirstName.isEmpty())
                    return true;
                else return false;
            }
        }finally {
            cursor.close();
        }
        return false;
    }

    private boolean doInsert(String englishWord, String russianWord){
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WordsListContract.WordsListEntry.COLUMN_TEACHER_FIRST_NAME, user.getFirstName());
        values.put(WordsListContract.WordsListEntry.COLUMN_TEACHER_LAST_NAME, user.getLastName());
        values.put(WordsListContract.WordsListEntry.COLUMN_ENGLISH_WORD, englishWord);
        values.put(WordsListContract.WordsListEntry.COLUMN_RUSSIAN_WORD, russianWord);

        long newRowId = db.insert(AuthorizationEntry.TABLE_NAME, null, values);
        return false;
    }
}
