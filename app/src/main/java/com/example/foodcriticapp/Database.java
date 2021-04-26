package com.example.foodcriticapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Database extends DataBaseHelper {
    public Database(@Nullable Context context) {
        super(context);
    }

    public long addReview(ContentValues values) {
        SQLiteDatabase db = getReadableDatabase();
        return db.insert("review", null, values);

    }

    public Cursor getReviewList() {
        SQLiteDatabase db = this.getReadableDatabase();
        String table = "review";
        String[] columns = {"foodItem", "userReview", "foodPrice"};
        String selection = "";
        String[] selectionArgs = {};
        String groupBy = null;
        String having = null;
        String orderBy = "foodItem Desc";
        String list = "100";

        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, list);

        return cursor;

    }
    public int deleteReview(String foodItem) {
        SQLiteDatabase db = getWritableDatabase();
        String column = "foodItem=?";
        String[] FoodItem = {foodItem};

        return db.delete("review",column, FoodItem);
    }

    public int saveReview(String search, String newValue) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("reviewInput",newValue);
        String[] searches = {search};

        return db.update("reviewInput",values,"reviewInput=?",searches);
    }
}
