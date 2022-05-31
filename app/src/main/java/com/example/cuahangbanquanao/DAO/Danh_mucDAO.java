package com.example.cuahangbanquanao.DAO;

import static com.example.cuahangbanquanao.GUI.MainActivity.sqLite_dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.cuahangbanquanao.DTO.Taikhoan;
import com.example.cuahangbanquanao.DTO.danhmuc;

import java.util.ArrayList;
import java.util.List;

public class Danh_mucDAO {

    public static Boolean them_danhmuc(danhmuc danhmuc) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tendm", danhmuc.getTendm());
        contentValues.put("hinhanh", danhmuc.getHinhanh());
        long result = MyDB.insert("danhmuc", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public static List<danhmuc> getall_danhmuc()  {
        List<danhmuc> danhmucs = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLite_dao.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * From danhmuc", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                danhmuc danhmuc = new danhmuc();
                danhmuc.setIddm(cursor.getInt(0));
                danhmuc.setTendm(cursor.getString(1));
                danhmuc.setHinhanh(cursor.getString(2));
                danhmucs.add(danhmuc);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return danhmucs;
    }
}
