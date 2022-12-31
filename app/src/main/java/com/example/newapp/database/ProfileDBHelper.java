package com.example.newapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ProfileDBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "two.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "profile";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USER_NAME = "name";
    private static final String COLUMN_USER_PIC = "image";

    public ProfileDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE "+TABLE_NAME+
                " ("+COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_USER_NAME + " TEXT); ";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addEntry (String name) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_NAME,name);

        long res = database.insert(TABLE_NAME,null,contentValues);

        if (res==-1)
            return false;
        else
            return true;

    }

    public Cursor readAllData() {
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if (db!=null) {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    public void updateData(String row_id,String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_NAME,name);

        long result = db.update(TABLE_NAME,contentValues,"_id=?",new String[] {row_id});

        if(result == -1) {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();
        }

    }
}
