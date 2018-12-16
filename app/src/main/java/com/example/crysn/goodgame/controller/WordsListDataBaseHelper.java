package com.example.crysn.goodgame.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.crysn.goodgame.model.AuthorizationContract.AuthorizationEntry;
import com.example.crysn.goodgame.model.WordsListContract;

public class WordsListDataBaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "words_list.db";

    public WordsListDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + WordsListContract.WordsListEntry.TABLE_NAME + " (" +
                WordsListContract.WordsListEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WordsListContract.WordsListEntry.COLUMN_TEACHER_FIRST_NAME + " TEXT NOT NULL," +
                WordsListContract.WordsListEntry.COLUMN_TEACHER_LAST_NAME + " TEXT NOT NULL," +
                WordsListContract.WordsListEntry.COLUMN_ENGLISH_WORD + " TEXT," +
                WordsListContract.WordsListEntry.COLUMN_RUSSIAN_WORD + " TEXT NOT NULL)";
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS " + WordsListContract.WordsListEntry.TABLE_NAME);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
