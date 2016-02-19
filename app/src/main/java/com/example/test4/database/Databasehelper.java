package com.example.test4.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by bridgelabz4 on 17/2/16.
 */
public class Databasehelper extends SQLiteOpenHelper {
    public  static  final String db_name="open_data1";
    public  static  final int db_version=2;



    public Databasehelper(Context context) {
        super(context, db_name, null, db_version);
        Log.d("databse operation","database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table " + Datajson.dataentry.tablename +
                "(user TEXT,id TEXT,title TEXT)");

//        db.execSQL("CREATE table " + Datajson.dataentry.tablename +
//                "(" + Datajson.dataentry.userid + "TEXT,"
//                + Datajson.dataentry.id + "text," + Datajson.dataentry.title + "text);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF  EXISTS"+Datajson.dataentry.tablename );


    }
    public void putinfo(String userId,String id2,String title2,SQLiteDatabase db){
        ContentValues contentValues= new ContentValues();
        contentValues.put(Datajson.dataentry.title2,userId);
        contentValues.put(Datajson.dataentry.id1,id2);
        contentValues.put(Datajson.dataentry.userid1, title2);
//        contentValues.put(Datajson.dataentry.Body, body);
        long result=db.insert(Datajson.dataentry.tablename,null,contentValues);
        Log.d("data inserted", "one row inserted");


    }
    public Cursor getinformation(SQLiteDatabase db){
        String[] projection={Datajson.dataentry.userid1,Datajson.dataentry.id1,Datajson.dataentry.title2,
        };
        Cursor cursor=db.query(Datajson.dataentry.tablename,projection,null,null,null,null,null);
        return cursor;
    }
}
