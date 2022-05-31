package com.example.cuahangbanquanao.DAO;

import static com.example.cuahangbanquanao.GUI.MainActivity.sqLite_dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cuahangbanquanao.DTO.donhang;
import com.example.cuahangbanquanao.DTO.giohang_;

import java.util.ArrayList;
import java.util.List;

public class don_hangDAO {
   // get_data("create Table IF NOT EXISTS donhang(iddh INTEGER PRIMARY KEY AUTOINCREMENT,idgh INTEGER, idtk INTEGER,loinhan nvarchar(500))");
   public static Boolean them_donhang(donhang donhang) {
       SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put("idgh", donhang.getIdgh());
       contentValues.put("idtk", donhang.getIdtk());
       contentValues.put("loinhan", donhang.getLoinhan());
       long result = MyDB.insert("donhang", null, contentValues);
       if (result == -1)
           return false;
       else
           return true;
   }

    public static List<donhang> getall_donhang() {
        List<donhang> donhangs = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLite_dao.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * From donhang", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                donhang donhang = new donhang();
                donhang.setIddh(cursor.getInt(0));
                donhang.setIdgh(cursor.getInt(1));
                donhang.setIdtk(cursor.getInt(2));
                donhang.setLoinhan(cursor.getString(3));
                donhangs.add(donhang);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return donhangs;
    }

    public static boolean xoa_donhang(int iddh) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        long result = MyDB.delete("donhang","iddh=?" , new String[]{String.valueOf(iddh)});
        if (result == -1)
            return false;
        else
            return true;
    }
}
