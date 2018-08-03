package com.example.farazpcir.masoud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by farazpc.ir on 26/08/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    private static String  DB_NAME="hotel";
    private static String DB_PATH="";
    private SQLiteDatabase mydatabase;
    private final Context mycontext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        if(Build.VERSION.SDK_INT>=15){
            DB_PATH=context.getApplicationInfo().dataDir + "/databases/";
        }else{
            DB_PATH= Environment.getDataDirectory()+"/data/"+context.getPackageName()+"/databases/";

        }
        this.mycontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void checkAndCopyDatabase(){
        boolean dbExit=checkDatabase();
        if(dbExit){
            Log.d("TAG","database already exists");
        }else{
            this.getReadableDatabase();
        }
        try {
            copyDatabase();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG","Error copy database");
        }
    }
    public boolean checkDatabase(){

        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;

            checkDB=SQLiteDatabase.openDatabase(myPath,null, SQLiteDatabase.OPEN_READWRITE);
        }catch (SQLiteException e){

        }
        if(checkDB!=null){
            checkDB.close();
        }
        return checkDB !=null ? true :false;
    }
    public void copyDatabase() throws IOException {
        InputStream myInput=mycontext.getAssets().open(DB_NAME);
        String outFileName=DB_PATH +DB_NAME;
        OutputStream myOutput=new FileOutputStream(outFileName);
        byte[] buffer=new byte[2048];
        int length;
        while((length=myInput.read(buffer))>0){
            myOutput.write(buffer,0,length);


        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public synchronized void close(){
        if(mydatabase!=null){
            mydatabase.close();
        }
        super.close();
    }
    public Cursor QueryData(String qeury){
        return mydatabase.rawQuery(qeury,null);

    }
    public void openDatabase(){
        String myPath=DB_PATH+DB_NAME;
        mydatabase=SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
    }
}
