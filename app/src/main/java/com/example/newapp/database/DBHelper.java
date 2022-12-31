package com.example.newapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "one.db";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_NAME = "abhinav";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "expense_title";
    private static final String COLUMN_AMOUNT = "expense_amount";
    private static final String COLUMN_DATE = "expense_date";



    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE "+TABLE_NAME+
                " ("+COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_TITLE + " TEXT, "+
                COLUMN_DATE + " TEXT, "+
                COLUMN_AMOUNT + " REAL); ";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

//    adding Data to the Database
    public boolean addEntry (String title,Double amount,String date) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(COLUMN_TITLE,title);
        contentValues.put(COLUMN_AMOUNT,amount);
        contentValues.put(COLUMN_DATE,date);

        long res =database.insert(TABLE_NAME,null,contentValues);

        if (res == -1) {
            return  false;
        } else {
            return true;
        }
    }

    // read the values from the database

    public Cursor readAllData() {
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if (db!=null) {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

}
