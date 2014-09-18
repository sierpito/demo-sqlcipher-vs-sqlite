package com.demo.sqlite;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.demo.sqlcipher.HelloSQLCipherActivity;

public class HelloSQLiteActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MySQLiteHelper helper = new MySQLiteHelper(getBaseContext());
        SQLiteDatabase database = helper.getWritableDatabase();
        TextView tvClick = (TextView) findViewById(R.id.tvClick);
        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloSQLiteActivity.this, HelloSQLCipherActivity.class);
                startActivity(intent);
            }
        });
    }
}