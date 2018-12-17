package com.example.crysn.goodgame.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.crysn.goodgame.model.AchievementsContract;
import com.example.crysn.goodgame.model.User;

import java.util.Vector;

public class AchievementsController {
    private AchievementsDataBaseHelper dataBaseHelper;

    public AchievementsController(Context context){
        dataBaseHelper = new AchievementsDataBaseHelper(context);
    }

    public void addPoints(int points, int maxpoints){
        Vector<Integer> ps = doSelect(RegistrationController.user.getFirstName(), RegistrationController.user.getLastName());
        Integer resPoints = points + ps.get(0);
        Integer resMaxPoints = maxpoints + ps.get(1);
        doUpdate(resPoints, resMaxPoints);
        RegistrationController.user.setMax(resMaxPoints);
        RegistrationController.user.setPoints(resPoints);
    }

    public void addStudentinAchievements(String studentFirstName, String studentLastName){
        doInsert(0,0,studentFirstName,studentLastName);
    }

    public Vector<Integer> doSelect(String studentFirstName, String studentLastName){
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        String[] projection = {
                AchievementsContract.AchievementsEntry.COLUMN_STUDENT_POINTS,
                AchievementsContract.AchievementsEntry.COLUMN_MAX_POINTS};
        String selection = AchievementsContract.AchievementsEntry.COLUMN_STUDENT_FIRST_NAME + "=? AND " + AchievementsContract.AchievementsEntry.COLUMN_STUDENT_LAST_NAME + "=?";
        String[] selectionArgs = {studentFirstName, studentLastName};
        Cursor cursor = db.query(
                AchievementsContract.AchievementsEntry.TABLE_NAME, // таблица
                projection,            // столбцы
                selection,             // столбцы для условия WHERE
                selectionArgs,         // значения для условия WHERE
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                AchievementsContract.AchievementsEntry.COLUMN_STUDENT_POINTS + " DESC");  // порядок сортировки
        Vector<Integer> res = new Vector<>();
        try {
            while (cursor.moveToNext()) {
                Integer points = cursor.getInt(cursor.getColumnIndex(AchievementsContract.AchievementsEntry.COLUMN_STUDENT_POINTS));
                Integer maxPoints = cursor.getInt(cursor.getColumnIndex(AchievementsContract.AchievementsEntry.COLUMN_MAX_POINTS));
                res.add(points);
                res.add(maxPoints);
            }
        }finally {
            cursor.close();
        }
        if (res.isEmpty()){
            doInsert(0,0,studentFirstName,studentLastName);
            res.add(0);
            res.add(0);
        }
        return res;
    }



    public void doInsert(Integer points, Integer maxPoints, String studentFirstName, String studentLastName){
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AchievementsContract.AchievementsEntry.COLUMN_TEACHER_FIRST_NAME, RegistrationController.user.getFirstName());
        values.put(AchievementsContract.AchievementsEntry.COLUMN_TEACHER_LAST_NAME, RegistrationController.user.getLastName());
        values.put(AchievementsContract.AchievementsEntry.COLUMN_STUDENT_FIRST_NAME, studentFirstName);
        values.put(AchievementsContract.AchievementsEntry.COLUMN_STUDENT_LAST_NAME, studentLastName);
        values.put(AchievementsContract.AchievementsEntry.COLUMN_STUDENT_POINTS, points);
        values.put(AchievementsContract.AchievementsEntry.COLUMN_MAX_POINTS, maxPoints);

        long newRowId = db.insert(AchievementsContract.AchievementsEntry.TABLE_NAME, null, values);
    }

    public void doUpdate(Integer points, Integer maxPoints){
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AchievementsContract.AchievementsEntry.COLUMN_STUDENT_POINTS, points);
        values.put(AchievementsContract.AchievementsEntry.COLUMN_MAX_POINTS, maxPoints);
        db.update(AchievementsContract.AchievementsEntry.TABLE_NAME,
                values,
                AchievementsContract.AchievementsEntry.COLUMN_STUDENT_FIRST_NAME + "= ? AND " + AchievementsContract.AchievementsEntry.COLUMN_STUDENT_LAST_NAME + "= ?", new String[]{RegistrationController.user.getFirstName(),RegistrationController.user.getLastName()});
    }

    public Vector<Integer> getStudentsPoints(String studentFirstName, String studentLastName){
        Vector<Integer> points = new Vector<>();
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        String[] projection = {
                AchievementsContract.AchievementsEntry.COLUMN_STUDENT_POINTS,
                AchievementsContract.AchievementsEntry.COLUMN_MAX_POINTS
        };
        String selection = AchievementsContract.AchievementsEntry.COLUMN_STUDENT_FIRST_NAME + "=? AND " + AchievementsContract.AchievementsEntry.COLUMN_STUDENT_LAST_NAME + "=?";
        String[] selectionArgs = {studentFirstName, studentLastName};
        Cursor cursor = db.query(
                AchievementsContract.AchievementsEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                AchievementsContract.AchievementsEntry.COLUMN_STUDENT_POINTS + " DESC");
        try{
            while(cursor.moveToNext()){
                Integer currentPoints = cursor.getInt(cursor.getColumnIndex(AchievementsContract.AchievementsEntry.COLUMN_STUDENT_POINTS));
                Integer currentMax = cursor.getInt(cursor.getColumnIndex(AchievementsContract.AchievementsEntry.COLUMN_MAX_POINTS));
                points.add(currentPoints);
                points.add(currentMax);
            }
        }finally {
            cursor.close();
        }
        if (points.isEmpty()){
            doInsert(0,0,studentFirstName,studentLastName);
            points.add(0);
            points.add(0);
        }
        return points;
    }

    public void delete(String studentFirstName, String studentLastName){
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        db.delete(AchievementsContract.AchievementsEntry.TABLE_NAME,"StudentFirstName=? and StudentLastName=?",new String[]{studentFirstName, studentLastName});
    }
}