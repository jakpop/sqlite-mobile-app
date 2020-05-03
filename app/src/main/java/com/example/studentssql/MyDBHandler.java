package com.example.studentssql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentDB.db";
    public static final String TABLE_NAME = "Students";
    public static final String COLUMN_ID = "StudentID";
    public static final String COLUMN_NAME = "StudentName";
    public static final String COLUMN_SURNAME = "StudentSurname";
    public static final String COLUMN_AGE = "StudentAge";
    public static final String COLUMN_PESEL = "StudentPESEL";
    public static final String COLUMN_GENDER = "StudentGender";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                COLUMN_NAME + " TEXT," + COLUMN_SURNAME + " TEXT," + COLUMN_AGE + " INTEGER," +
                COLUMN_PESEL + " TEXT," + COLUMN_GENDER +" TEXT )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public String loadHandler() {

        String result = "";
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            String result_2 = cursor.getString(2);
            int result_3 = cursor.getInt(3);
            String result_4 = cursor.getString(4);
            String result_5 = cursor.getString(5);
            result += String.valueOf(result_0) + " " + result_1 + " " + result_2 + " " +
                    String.valueOf(result_3) + " " + result_4 + " " + result_5 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public void addHandler(Student student) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_SURNAME, student.getSurname());
        values.put(COLUMN_AGE, student.getAge());
        values.put(COLUMN_PESEL, student.getPesel());
        values.put(COLUMN_GENDER, student.getGender());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
