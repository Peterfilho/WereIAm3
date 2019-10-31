package com.example.wereiam3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "were_i_am";

    private static final String TABLE_LOCAL = "tb_locales";
    private static final String COLUM_ID = "id";
    private static final String COLUM_NAME = "name";
    private static final String COLUM_AP1 = "ap1";
    private static final String COLUM_AP2 = "ap2";
    private static final String COLUM_AP3 = "ap3";
    private static final String COLUM_AP4 = "ap4";
    private static final String COLUM_AP5 = "ap5";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String QUERY_COLUM = "CREATE TABLE " + TABLE_LOCAL + "(" + COLUM_ID + " INTEGER PRIMARY KEY, "
                + COLUM_NAME + " TEXT,"
                + COLUM_AP1 + " TEXT,"
                + COLUM_AP2 + " TEXT,"
                + COLUM_AP3 + " TEXT,"
                + COLUM_AP4 + " TEXT,"
                + COLUM_AP5 + " TEXT)";


        db.execSQL(QUERY_COLUM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }

    void addApData(Access_point ap) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUM_NAME, ap.getName());
        values.put(COLUM_AP1, ap.getAp1());
        values.put(COLUM_AP2, ap.getAp2());
        values.put(COLUM_AP3, ap.getAp3());
        values.put(COLUM_AP4, ap.getAp4());
        values.put(COLUM_AP5, ap.getAp5());

        database.insert(TABLE_LOCAL, null, values);
        database.close();
    }

    void deleteApData(Access_point ap) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_LOCAL, COLUM_ID + " = ?", new String[] {String.valueOf(ap.getId())});
       // db.delete(TABLE_LOCAL, COLUM_ID + " = ?", new String[] {String.valueOf(ap.getId())});

        db.close();
    }

    Access_point selectData (int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_LOCAL, new String[] {COLUM_ID,
                COLUM_NAME,
                COLUM_AP1,
                COLUM_AP2,
                COLUM_AP3,
                COLUM_AP4,
                COLUM_AP5}, COLUM_ID + " = ?",
                new String[] {String.valueOf(id)}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Access_point access_point = new Access_point(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6));

        return access_point;
    }

    void updateData (Access_point ap) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUM_NAME, ap.getName());
        values.put(COLUM_AP1, ap.getAp1());
        values.put(COLUM_AP2, ap.getAp2());
        values.put(COLUM_AP3, ap.getAp3());
        values.put(COLUM_AP4, ap.getAp4());
        values.put(COLUM_AP5, ap.getAp5());

        db.update(TABLE_LOCAL, values, COLUM_ID + " = ?",
                new String[] {String.valueOf(ap.getId())});
    }
}
