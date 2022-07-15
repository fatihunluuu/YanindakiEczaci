package com.example.laprospekts;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Mydatabase extends SQLiteOpenHelper {

    private static final String table_name = "ilaclar_tablosu";

    public Mydatabase(Context context) {
        super(context, "mydatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE ilaclar_tablosu(barkod long PRIMARY KEY, ilac_adi text, ilac_fiyat text)");
        db.execSQL(" CREATE TABLE uretici_firma(id long PRIMARY KEY, firma_adi text, adres text, telefon text, mail text)");
        db.execSQL(" CREATE TABLE icerik_tablosu(barkod long PRIMARY KEY, kullanimAmaci text, kullanilmamasiGereken text, yanEtki text, kTalimati text, etkenMadde text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ilaclar_tablosu");
        db.execSQL("drop table if exists uretici_firma");
        db.execSQL("drop table if exists icerik_talosu");

    }

    public boolean insertilaclar(long ilacbarkodu, String ilacAdi, String ilacFiyati) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("barkod", ilacbarkodu);
        contentValues.put("ilac_adi", ilacAdi);
        contentValues.put("ilac_fiyat", ilacFiyati);
        long result = db.insert("ilaclar_tablosu", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean insertfirma(long id, String firma_adi, String Adres, String Telefon, String Mail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("firma_adi", firma_adi);
        contentValues.put("adres", Adres);
        contentValues.put("telefon", Telefon);
        contentValues.put("mail", Mail);
        long result = db.insert("uretici_firma", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean inserticerik(long Barkod, String kullanim_Amaci, String kullanilmamasi_Gereken, String yan_Etki, String k_Talimati, String etken_Madde) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("barkod", Barkod);
        contentValues.put("kullanimAmaci", kullanim_Amaci);
        contentValues.put("kullanilmamasiGereken", kullanilmamasi_Gereken);
        contentValues.put("yanEtki", yan_Etki);
        contentValues.put("kTalimati", k_Talimati);
        contentValues.put("etkenMadde", etken_Madde);
        long result = db.insert("icerik_tablosu", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<HashMap<String, String>> ilaclar(){

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + table_name;
        Cursor cursor = db.rawQuery(selectQuery, null);
            ArrayList<HashMap<String, String>> ilac_list = new ArrayList<HashMap<String, String>>();
            if (cursor.moveToFirst()){
                do {
                    HashMap<String, String> map = new HashMap<String, String>();
                    for (int i = 0; i<cursor.getColumnCount();i++){
                        map.put(cursor.getColumnName(i), cursor.getString(i));
                    }
                    ilac_list.add(map);
                }while (cursor.moveToNext());
            }
            db.close();
            return ilac_list;
    }

    public HashMap<String, String> ilacDetay(long barkod){
        HashMap<String, String> ilac = new HashMap<>();
        String query = "SELECT * FROM icerik_tablosu WHERE barkod="+barkod;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();
        if(cursor.getCount()>0){
            ilac.put("kullanimAmaci", cursor.getString(1));
            ilac.put("kullanilmamasiGereken", cursor.getString(2));
            ilac.put("yanEtki", cursor.getString(3));
            ilac.put("kTalimati", cursor.getString(4));
            ilac.put("etkenMadde", cursor.getString(5));
        }
        cursor.close();

        String query2 = "SELECT * FROM " + table_name + " WHERE barkod="+barkod;
        Cursor cursor2 = db.rawQuery(query2, null);

        cursor2.moveToFirst();
        if(cursor2.getCount()>0){
            ilac.put("ilac_adi", cursor2.getString(1));
            ilac.put("ilac_fiyat", cursor2.getString(2));
        }
        cursor2.close();
        db.close();
        return ilac;
    }
    public HashMap<String, String> firmaDetay(long barkod){
        HashMap<String, String> firma = new HashMap<>();
        String query = "SELECT * FROM uretici_firma WHERE id="+barkod;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        cursor.moveToFirst();
        if (cursor.getCount()>0){
            firma.put("firma_adi", cursor.getString(1));
            firma.put("adres", cursor.getString(2));
            firma.put("telefon", cursor.getString(3));
            firma.put("mail", cursor.getString(4));
        }
        cursor.close();
        db.close();
        return firma;
    }




}