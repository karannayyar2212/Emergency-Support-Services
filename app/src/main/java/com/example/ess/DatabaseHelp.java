package com.example.ess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelp extends SQLiteOpenHelper {
    public DatabaseHelp( Context context) {
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(First_NAME text ,Last_NAME text,mobile number primary key ,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");

    }//inserting in database
    public boolean insert(String First_NAME,String Last_NAME,String mobile,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("first_name",First_NAME);
        contentValues.put("last_name",Last_NAME);
        contentValues.put("mobile",mobile);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);

        if(ins==-1) return  false;
        else return true;
    }
    //if number exists
    public boolean chkemail(String mobile){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where mobile=?",new String[]{mobile});

        if(cursor.getCount()>0) return false;
        else return true;
    }
    //checking the email and password

    public Boolean emailpassword(String email,String password){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0) return true;
        else return false;

    }
}
