package com.example.crysn.goodgame.model;

import android.provider.BaseColumns;

public class AchievementsContract {
    public AchievementsContract() {
    }

    public static class AchievementsEntry implements BaseColumns {
        public static final String TABLE_NAME = "achievements";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_TEACHER_FIRST_NAME = "TeacherFirstName";
        public static final String COLUMN_TEACHER_LAST_NAME = "TeacherLastName";
        public static final String COLUMN_STUDENT_FIRST_NAME = "StudentFirstName";
        public static final String COLUMN_STUDENT_LAST_NAME = "StudentLastName";
        public static final String COLUMN_STUDENT_POINTS = "StudentsPoints";
        public static final String COLUMN_MAX_POINTS = "MaxPoints";
    }
}
