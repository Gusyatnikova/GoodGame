package com.example.crysn.goodgame.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.crysn.goodgame.model.AuthorizationContract.AuthorizationEntry;
import com.example.crysn.goodgame.model.User;

public class RegistrationController {

    private AuthorizationDataBaseHelper dataBaseHelper;
    public static User user;

    public RegistrationController(Context context) {
        dataBaseHelper = new AuthorizationDataBaseHelper(context);
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
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        String[] projection = {
                AuthorizationEntry.COLUMN_NAME,
                AuthorizationEntry.COLUMN_LAST_NAME,
                AuthorizationEntry.REGISTRATOR};
        String selection = AuthorizationEntry.LOGIN + "=? AND " + AuthorizationEntry.PASSWORD + "=?";
        String[] selectionArgs = {login, pswd};
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
                String currentRegistator = cursor.getString(cursor.getColumnIndex(AuthorizationEntry.REGISTRATOR));
                if (currentFirstName.isEmpty() || currentLastName.isEmpty())
                    return false;
                else {
                    user = new User(login, pswd, currentFirstName, currentLastName, currentRegistator);
                    return true;
                }
            }
        } finally {
            cursor.close();
        }
        return false;
    }

    private boolean doInsert(String firstname, String lastname, String registrator, String login, String password) {
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AuthorizationEntry.COLUMN_NAME, firstname);
        values.put(AuthorizationEntry.COLUMN_LAST_NAME, lastname);
        values.put(AuthorizationEntry.REGISTRATOR, registrator);
        values.put(AuthorizationEntry.LOGIN, login);
        values.put(AuthorizationEntry.PASSWORD, password);

        long newRowId = db.insert(AuthorizationEntry.TABLE_NAME, null, values);
        return false;
    }
}
