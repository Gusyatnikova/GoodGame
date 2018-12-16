package com.example.crysn.goodgame.model;

import android.provider.BaseColumns;

public final class AuthorizationContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private AuthorizationContract() {}

    /* Inner class that defines the table contents */
    public static class AuthorizationEntry implements BaseColumns {
        public static final String TABLE_NAME = "authorization";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "FirstName";
        public static final String COLUMN_LAST_NAME = "Last_Name";
        public static final String REGISTRATOR = "TeachersLastName";
        public static final String LOGIN = "Login";
        public static final String PASSWORD = "Password";
    }
}
