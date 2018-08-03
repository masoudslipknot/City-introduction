package com.example.farazpcir.masoud;


import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.Toast;


import com.example.farazpcir.masoud.adapter.resturanadapter;
import com.example.farazpcir.masoud.adapter.shopadapter;
import com.example.farazpcir.masoud.item.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SecendActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //  private DatabaseHelper databaseHelper;
    private ArrayList<item> arrayList=new ArrayList<item>();
    private Cursor cursor;
    private shopadapter  shopadapter;
    private resturanadapter  resturanadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
        Bundle b=getIntent().getExtras();

        recyclerView = (RecyclerView) findViewById(R.id.RV);
        if(b!=null) {
            int u=b.getInt("whichone");
            if(u==1) {
                LoadDataBase();
            }else if(u==2){
                loadfromres();
            }
        }

    }
    public void loadfromres(){
        final int who=1;
        final int idenfier=1;



        DatabaseHelper databaseHelper=new DatabaseHelper(SecendActivity.this);
        databaseHelper.checkAndCopyDatabase();
        databaseHelper.openDatabase();
        cursor=databaseHelper.QueryData("SELECT * FROM resturant");
        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{
                    item item=new item();
                    item.setPicturename(cursor.getString(cursor.getColumnIndex("picturename")));
                    item.setName(cursor.getString(cursor.getColumnIndex("name")));
                    arrayList.add(item);

                }while(cursor.moveToNext());
            }
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SecendActivity.this);
        resturanadapter=new resturanadapter(arrayList);

        resturanadapter.setOnTapListener(new OnTapListener() {
            @Override
            public void OnTapView(int position) {
                Toast.makeText(SecendActivity.this,"click to "+position,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(SecendActivity.this,ThirdActivity.class);
                intent.putExtra("id",idenfier);
                intent.putExtra("who",who);
                intent.putExtra("position identifier",position);
                SecendActivity.this.startActivity(intent);


            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(resturanadapter);

    }
    public void LoadDataBase(){
        final int idenfier=0;
        final int who=2;



        DatabaseHelper databaseHelper=new DatabaseHelper(SecendActivity.this);
        databaseHelper.checkAndCopyDatabase();
        databaseHelper.openDatabase();
        cursor=databaseHelper.QueryData("SELECT * FROM shoping");
        if(cursor!=null){
            if(cursor.moveToFirst()){
                do{
                    item item=new item();
                    item.setPicturename(cursor.getString(cursor.getColumnIndex("picturename")));
                    item.setName(cursor.getString(cursor.getColumnIndex("name")));
                    arrayList.add(item);

                }while(cursor.moveToNext());
            }
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SecendActivity.this);
        shopadapter=new shopadapter(arrayList);

        shopadapter.setOnTapListener(new OnTapListener() {
            @Override
            public void OnTapView(int position) {
                Toast.makeText(SecendActivity.this,"click to "+position,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(SecendActivity.this,ThirdActivity.class);
                intent.putExtra("who",who);
                intent.putExtra("id",idenfier);
                intent.putExtra("position identifier",position);
                SecendActivity.this.startActivity(intent);


            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(shopadapter);

    }


}

