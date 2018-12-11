package com.example.okejon.insideout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "inside.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
// TODO Auto-generated constructor stub
    }     @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub

        String sql1 = "create table curhat (id_cur integer primary key, tanggal date, keterangan text null, lokasi text null);";
        Log.d("Data", "onCreate: " + sql1);
        db.execSQL(sql1);
        sql1 = "INSERT INTO supplier (id_sup, nama) VALUES ('1', 'PT Adidas Ina'),('2', 'PT Nike Ina');";
        db.execSQL(sql1);




    }     @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2)     {
// TODO Auto-generated method stub
    } }
