package com.demo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "sqlite.db";
    private static final String SQL_CREATE = "create table t1(a text not null, b text not null)";
    private static final String SQL_INSERT = "insert into t1(a, b) values('one for the money', 'two for the show')";
    private static final String SQL_DROP = "drop table if exists t1";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        try {
            database.execSQL(SQL_CREATE);
            database.execSQL(SQL_INSERT);
        } catch (Exception e) {
            Log.v("MySQLiteHelper", "exception in sql");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP);
        this.onCreate(db);
    }
}
