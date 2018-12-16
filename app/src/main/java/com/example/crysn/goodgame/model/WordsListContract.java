package com.example.crysn.goodgame.model;

import android.provider.BaseColumns;

public final class WordsListContract {
    private WordsListContract() {}

    /* Inner class that defines the table contents */
    public static class WordsListEntry implements BaseColumns {
        public static final String TABLE_NAME = "words_list";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_TEACHER_FIRST_NAME = "TeacherFirstName";
        public static final String COLUMN_TEACHER_LAST_NAME = "TeacherLastName";
        public static final String COLUMN_ENGLISH_WORD = "EnglishWord";
        public static final String COLUMN_RUSSIAN_WORD = "RussianWord";
    }
}
