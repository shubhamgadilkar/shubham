package com.shubham.hospitalmanagement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="patientinfo.db";
    public static final String TABLE_NAME="patient_details";
    public static final String COL0="ID";
    public static final String COL1="patient_name";
    public static final String COL2="patient_address";
    public static final String COL3="age";
    public static final String COL4="weight";
    public static final String COL5="height";
    public static final String COL6="contact";
    public static final String COL7="disease_name";
    public static final String COL8="drug";
    public static final String COL9="doc_name";

    public MyDbHandler(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTable="CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "patient_name,patient_address,age,weight,height,contact,disease_name,drug,doc_name)";
    db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    public boolean addData(String patient_name,String patient_address,String age,String weight,String height,String contact,String disease_name,String drug,String doc_name ){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1,patient_name);
        contentValues.put(COL2,patient_address);
        contentValues.put(COL3,age);
        contentValues.put(COL4,weight);
        contentValues.put(COL5,height);
        contentValues.put(COL6,contact);
        contentValues.put(COL7,disease_name);
        contentValues.put(COL8,drug);
        contentValues.put(COL9,doc_name);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;

        }else{
            return true;
        }


    }
    public Cursor showData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return data;
    }
    public boolean updateData(String ID,String patient_name,String patient_address,String age,String weight,String height,String contact,String disease_name,String drug,String doc_name){
    SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL0,ID);
        contentValues.put(COL1,patient_name);
        contentValues.put(COL2,patient_address);
        contentValues.put(COL3,age);
        contentValues.put(COL4,weight);
        contentValues.put(COL5,height);
        contentValues.put(COL6,contact);
        contentValues.put(COL7,disease_name);
        contentValues.put(COL8,drug);
        contentValues.put(COL9,doc_name);
        db.update(TABLE_NAME,contentValues,"ID =?",new String[] {ID});
        return true;

    }
    public Integer deleteData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID=?",new String[] {id});


    }
}
