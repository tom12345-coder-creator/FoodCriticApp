package com.example.foodcriticapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(@Nullable Context context) {
        super(context, "reviewDb.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table if not exists review (" +
                "foodName text,"+
                "foodPrice int," +
                "reviewInput text" +
                ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = "drop table if exists review";
        db.execSQL(dropTable);
        onCreate(db);

    }
}
