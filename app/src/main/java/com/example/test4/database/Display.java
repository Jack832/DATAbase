package com.example.test4.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class Display extends AppCompatActivity {
    RecyclerView r1;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Recycleid> arr= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        r1= (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        r1.setLayoutManager(layoutManager);

        r1.setHasFixedSize(true);

        //retrive the data from database

        Databasehelper databasehelper1= new Databasehelper(this);
        SQLiteDatabase sqLiteDatabase1=databasehelper1.getReadableDatabase();

        Cursor c=databasehelper1.getinformation(sqLiteDatabase1);
        c.moveToFirst();
        do{
            Recycleid  recycleid=new Recycleid(c.getString(0),c.getString(1),c.getString(2));
            arr.add(recycleid);

        }while (c.moveToNext());

        databasehelper1.close();
        adapter = new Adapter(arr);
        r1.setAdapter(adapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
