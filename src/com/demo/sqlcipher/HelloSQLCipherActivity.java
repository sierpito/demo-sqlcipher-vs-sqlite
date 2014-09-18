package com.demo.sqlcipher;

import java.io.File;

import com.demo.sqlite.R;
import net.sqlcipher.database.SQLiteDatabase;
import android.app.Activity;
import android.os.Bundle;

public class HelloSQLCipherActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initializeSQLCipher();
    }

    private void initializeSQLCipher() {
        SQLiteDatabase.loadLibs(this);
        createDb("sqlchiper-nopassword.db", "");
        createDb("sqlchiper-test123.db", "test123");
    }

    private void createDb(String name, String password) {
        File databaseFile = getDatabasePath(name);
        databaseFile.mkdirs();
        databaseFile.delete();
        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(databaseFile, password, null);
        database.execSQL("create table t1(a text not null, b text not null)");
        database.execSQL("insert into t1(a, b) values(?, ?)", new Object[]{"one for the money", "two for the show"});
    }
}