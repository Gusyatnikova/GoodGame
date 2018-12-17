package com.example.crysn.goodgame.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.crysn.goodgame.model.AuthorizationContract.AuthorizationEntry;
import com.example.crysn.goodgame.model.User;
import com.example.crysn.goodgame.model.Word;
import com.example.crysn.goodgame.model.WordsListContract;

import java.util.ArrayList;

public class RegistrationController {

    private AuthorizationDataBaseHelper dataBaseHelper;
    public static User user;
    private WordListController wordListController;
    public static AchievementsController achievementsController;

    public RegistrationController(Context context) {
        dataBaseHelper = new AuthorizationDataBaseHelper(context);
        wordListController = new WordListController(context);
        achievementsController = new AchievementsController(context);
    }

    public boolean validate(String login, String pswd) {
        if (login.isEmpty() || pswd.isEmpty())
            return false;
        else {
            boolean isIn = doSelect(login, pswd);
            if (!isIn)
                return false;
            else return true;
        }
    }

    private boolean doSelect(String login, String pswd) {
        String selection;
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        String[] projection = {
                AuthorizationEntry.COLUMN_NAME,
                AuthorizationEntry.COLUMN_LAST_NAME,
                AuthorizationEntry.REGISTRATOR_FIRST_NAME,
                AuthorizationEntry.REGISTRATOR_LAST_NAME,};
        String[] selectionArgs;
        if(pswd != "insystem") {
            selection = AuthorizationEntry.LOGIN + "=? AND " + AuthorizationEntry.PASSWORD + "=?";
            selectionArgs = new String[]{login, pswd};
        } else {
            selection = AuthorizationEntry.LOGIN + "=?";
            selectionArgs = new String[]{login};
        }
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
                String currentFirstName = cursor.getString(cursor.getColumnIndex(AuthorizationEntry.COLUMN_NAME));
                String currentLastName = cursor.getString(cursor.getColumnIndex(AuthorizationEntry.COLUMN_LAST_NAME));
                String currentRegistatorFirstName = cursor.getString(cursor.getColumnIndex(AuthorizationEntry.REGISTRATOR_FIRST_NAME));
                String currentRegistatorLastName = cursor.getString(cursor.getColumnIndex(AuthorizationEntry.REGISTRATOR_LAST_NAME));
                if (currentFirstName.isEmpty() || currentLastName.isEmpty())
                    return false;
                else {
                    user = new User(login, pswd, currentFirstName, currentLastName, currentRegistatorFirstName, currentRegistatorLastName);
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            user.setWords(wordListController.getWordsByTeacher(user.getRegistratorFirstName(), user.getRegistratorLastName()));
                        }
                    });
                    Thread thr = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            user.setAchievements(achievementsController.getStudentsPoints(user.getFirstName(),user.getLastName()));
                        }
                    });
                    thread.start();
                    return true;
                }
            }
        } finally {
            cursor.close();
        }
        return false;
    }

    public ArrayList<String> doSelect(String teacherFirstName, String teacherLastName, boolean type){
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        String[] projection = {
                AuthorizationEntry.COLUMN_NAME,
                AuthorizationEntry.COLUMN_LAST_NAME};
        String selection = AuthorizationEntry.REGISTRATOR_FIRST_NAME + "=? AND " + AuthorizationEntry.REGISTRATOR_LAST_NAME + "=?";
        String[] selectionArgs = {teacherFirstName, teacherLastName};
        Cursor cursor = db.query(
                AuthorizationEntry.TABLE_NAME, // таблица
                projection,            // столбцы
                selection,             // столбцы для условия WHERE
                selectionArgs,         // значения для условия WHERE
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                AuthorizationEntry.COLUMN_NAME + " DESC");  // порядок сортировки
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                String currentFirstName = cursor.getString(cursor.getColumnIndex(AuthorizationEntry.COLUMN_NAME));
                String currentLastName = cursor.getString(cursor.getColumnIndex(AuthorizationEntry.COLUMN_LAST_NAME));
                arrayList.add(currentFirstName + " " + currentLastName);
            }
        }finally {
            cursor.close();
        }
        return arrayList;
    }

    public boolean doInsert(String firstname, String lastname, String registratorFirstName, String registratorLastName, String login, String password) {
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AuthorizationEntry.COLUMN_NAME, firstname);
        values.put(AuthorizationEntry.COLUMN_LAST_NAME, lastname);
        values.put(AuthorizationEntry.REGISTRATOR_FIRST_NAME, registratorFirstName);
        values.put(AuthorizationEntry.REGISTRATOR_LAST_NAME, registratorLastName);
        values.put(AuthorizationEntry.LOGIN, login);
        values.put(AuthorizationEntry.PASSWORD, password);

        long newRowId = db.insert(AuthorizationEntry.TABLE_NAME, null, values);
        return false;
    }
    public void delete(String firstName, String lastName){
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        db.delete(AuthorizationEntry.TABLE_NAME, "FirstName=? and LastName=?",new String[]{firstName, lastName});
    }
}
