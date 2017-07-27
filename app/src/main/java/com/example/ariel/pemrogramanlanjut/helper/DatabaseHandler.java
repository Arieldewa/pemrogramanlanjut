package com.example.ariel.pemrogramanlanjut.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ariel.pemrogramanlanjut.object.PensMHS;

import java.util.ArrayList;

/**
 * Created by Ariel on 5/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int db_version = 1;
    private static final String db_name = "Pens";
    private static final String table_name = "PensMHS";

    //kolom table
    private static final String nrp = "nrp";
    private static final String nama = "nama";
    private static final String jurusan = "jurusan";

    public DatabaseHandler(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table = "create table "+table_name+" ( nrp integer primary key, nama text , jurusan text)";
        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(sqLiteDatabase);
    }

    public void addMHS(PensMHS mhs){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(nrp,mhs.getNrp());
        val.put(nama,mhs.getName());
        val.put(jurusan,mhs.getJurusan());

        db.insert(table_name,null,val);
        db.close();
    }
    public PensMHS getMhs(int i){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(table_name,new String[]{nrp,nama,jurusan},nrp + "=?",new String []{String.valueOf(i)},null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        PensMHS mhs = new PensMHS(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));
        return mhs;
    }
    public ArrayList<PensMHS> getAllMHS(){
        ArrayList<PensMHS> mhslist = new ArrayList<>();

        String select = "select * from "+table_name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select,null);

        if (cursor.moveToFirst()){
            do {
                PensMHS mhs = new PensMHS();
                mhs.setNrp(Integer.parseInt(cursor.getString(0)));
                mhs.setName(cursor.getString(1));
                mhs.setJurusan(cursor.getString(2));
                mhslist.add(mhs);
            }while(cursor.moveToNext());
        }
        return mhslist;
    }
    public void deleteMHS(PensMHS o){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(table_name,nrp + "=?",new String[]{String.valueOf(o.getNrp())});
        db.close();
    }
    public int updateMHS(PensMHS o){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(nama,o.getName());
        val.put(jurusan,o.getJurusan());

        return db.update(table_name,val,nrp + "=?",new String[]{String.valueOf(o.getNrp())});
    }
    public  int getCount(){
        String count = "select * from "+table_name;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(count,null);
        cursor.close();

        return cursor.getCount();
    }

    public void updateAllmhs(){
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "UPDATE "+ table_name +" SET jurusan = REPLACE(jurusan,'I',' Informatika')";
        db.execSQL(where);

    }
}
