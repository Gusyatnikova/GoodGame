package com.example.crysn.goodgame.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.crysn.goodgame.model.AchievementsContract;

public class AchievementsDataBaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "achievements.db";

    public AchievementsDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + AchievementsContract.AchievementsEntry.TABLE_NAME + " (" +
                AchievementsContract.AchievementsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                AchievementsContract.AchievementsEntry.COLUMN_TEACHER_FIRST_NAME + " TEXT NOT NULL," +
                AchievementsContract.AchievementsEntry.COLUMN_TEACHER_LAST_NAME + " TEXT NOT NULL," +
                AchievementsContract.AchievementsEntry.COLUMN_STUDENT_FIRST_NAME + " TEXT NOT NULL," +
                AchievementsContract.AchievementsEntry.COLUMN_STUDENT_LAST_NAME + " TEXT NOT NULL," +
                AchievementsContract.AchievementsEntry.COLUMN_STUDENT_POINTS + " INTEGER NOT NULL," +
                AchievementsContract.AchievementsEntry.COLUMN_MAX_POINTS + " INTEGER NOT NULL)";
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + AchievementsContract.AchievementsEntry.TABLE_NAME);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
