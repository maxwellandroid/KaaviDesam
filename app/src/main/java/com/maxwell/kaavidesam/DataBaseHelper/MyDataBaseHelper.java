package com.maxwell.kaavidesam.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.maxwell.kaavidesam.TableDetails;

import java.util.ArrayList;
import java.util.List;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "kaavidesamDB.db";
    public static final String TABLE_NAME = "DetailsList";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NALLA_NERAM="NallaNeram";
    public static final String COLUMN_RAHUKALA_TIME ="Rahukalam";
    public static final String COLUMN_WEEK = "Week";
    public static final String COLUMN_KULIGAI ="Kuligai";
    public static final String COLUMN_YAMAKANTAKALA_TIME ="Yamakantam";
    public static final String COLUMN_VAARASOOLAI ="VaaraSoolai";
    public static final String COLUMN_PARIGARAM ="Parigaram";
    public static final String COLUMN_TIME="DateTime";

    TableDetails entryTableDetails;
    TableDetails entryTable;
    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table " +TABLE_NAME+
                        "("+COLUMN_ID+ " integer primary key,"+ COLUMN_WEEK +" text,"+ COLUMN_RAHUKALA_TIME +" text,"+COLUMN_NALLA_NERAM +" text,"+ COLUMN_KULIGAI +" text,"+ COLUMN_YAMAKANTAKALA_TIME +" text,"+ COLUMN_VAARASOOLAI +" text,"+ COLUMN_PARIGARAM +" text)"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean addEntry(TableDetails tableDetails){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_RAHUKALA_TIME, tableDetails.getRahukalam());
        contentValues.put(COLUMN_WEEK, tableDetails.getWeek());
        contentValues.put(COLUMN_NALLA_NERAM,tableDetails.getNallaneram());
        contentValues.put(COLUMN_KULIGAI, tableDetails.getKuligai());
        contentValues.put(COLUMN_YAMAKANTAKALA_TIME, tableDetails.getYamakantam());
        contentValues.put(COLUMN_VAARASOOLAI, tableDetails.getSoolai());
        contentValues.put(COLUMN_PARIGARAM, tableDetails.getParigaram());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public Cursor getData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME+" where "+ COLUMN_WEEK +"='"+id+"'", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }
    public boolean updateCart(TableDetails entryTableDetails){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_RAHUKALA_TIME, entryTableDetails.getRahukalam());
        contentValues.put(COLUMN_WEEK, entryTableDetails.getWeek());
        contentValues.put(COLUMN_KULIGAI, entryTableDetails.getKuligai());
        contentValues.put(COLUMN_NALLA_NERAM,entryTableDetails.getNallaneram());
        contentValues.put(COLUMN_YAMAKANTAKALA_TIME, entryTableDetails.getYamakantam());
        contentValues.put(COLUMN_VAARASOOLAI,entryTableDetails.getSoolai());
        contentValues.put(COLUMN_PARIGARAM,entryTableDetails.getParigaram());
        db.update(TABLE_NAME, contentValues, COLUMN_WEEK +" = ? ", new String[] {entryTableDetails.getWeek() } );
        db.close();
        return true;
    }

    public Integer deleteEntry (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                COLUMN_TIME +"= ? ",
                new String[] { id });
    }


        public List<TableDetails> getAllEntries() {
        List<TableDetails> entryTableDetailsList = new ArrayList<TableDetails>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
      //  res.moveToFirst();

        while(res.moveToNext()){
            this.entryTableDetails =new TableDetails();
            this.entryTableDetails.setWeek(res.getString(res.getColumnIndex(COLUMN_WEEK)));
            this.entryTableDetails.setRahukalam(res.getString(res.getColumnIndex(COLUMN_RAHUKALA_TIME)));
            this.entryTableDetails.setNallaneram(res.getString(res.getColumnIndex(COLUMN_NALLA_NERAM)));
            this.entryTableDetails.setKuligai(res.getString(res.getColumnIndex(COLUMN_KULIGAI)));
            this.entryTableDetails.setYamakantam(res.getString(res.getColumnIndex(COLUMN_YAMAKANTAKALA_TIME)));
            this.entryTableDetails.setSoolai(res.getString(res.getColumnIndex(COLUMN_VAARASOOLAI)));
            this.entryTableDetails.setParigaram(res.getString(res.getColumnIndex(COLUMN_PARIGARAM)));
           // this.entryTableDetails.setTime(res.getString(res.getColumnIndex(COLUMN_TIME)));
            entryTableDetailsList.add(this.entryTableDetails);
           // res.moveToNext();
        }
        res.close();
        db.close();
        return entryTableDetailsList;
    }

}
