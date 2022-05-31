package com.example.cuahangbanquanao.DAO;

import static com.example.cuahangbanquanao.GUI.MainActivity.email_;
import static com.example.cuahangbanquanao.GUI.MainActivity.sqLite_dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.example.cuahangbanquanao.DTO.giohang_;
import com.example.cuahangbanquanao.DTO.sanpham;

import java.util.ArrayList;
import java.util.List;

public class gio_hangDAO {
    //get_data("create Table IF NOT EXISTS giohang(idgh INTEGER PRIMARY KEY AUTOINCREMENT,idtk INTEGER,GER, idsp INTEGER,sl INTEGER,tongtien INTEGER)");

    public static Boolean them_giohang(giohang_ giohang_) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idtk", giohang_.getIdtk());
        contentValues.put("idsp", giohang_.getIdsp());
        contentValues.put("sl", giohang_.getSl());
        contentValues.put("tongtien", giohang_.getTongtien());
        contentValues.put("trangthai", giohang_.getTrangthai());
        long result = MyDB.insert("giohang", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public static List<giohang_> getall_giohang() {
        List<giohang_> giohang_s = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLite_dao.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * From giohang where trangthai = ?", new String[]{String.valueOf(0)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                giohang_ giohang_ = new giohang_();
                giohang_.setIdgh(cursor.getInt(0));
                giohang_.setIdtk(cursor.getInt(1));
                giohang_.setIdsp(cursor.getInt(2));
                giohang_.setSl(cursor.getInt(3));
                giohang_.setTongtien(cursor.getInt(4));
                giohang_.setTrangthai(cursor.getInt(5));
                giohang_s.add(giohang_);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return giohang_s;
    }
    public static giohang_ get_giohang(int idgh) {
        giohang_ giohang_ = new giohang_();
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from giohang where idgh = ?", new String[]{String.valueOf(idgh)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            giohang_.setIdgh(cursor.getInt(0));
            giohang_.setIdtk(cursor.getInt(1));
            giohang_.setIdsp(cursor.getInt(2));
            giohang_.setSl(cursor.getInt(3));
            giohang_.setTongtien(cursor.getInt(4));
            giohang_.setTrangthai(cursor.getInt(5));
            cursor.close();
            return giohang_;
        }
        return null;
    }
    public static boolean Sua_giohang(int idgh, int sl, int tongtien) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sl",sl);
        contentValues.put("tongtien", tongtien);
        long result = MyDB.update("giohang",contentValues,"idgh=?" , new String[]{String.valueOf(idgh)});
        if (result == -1)
            return false;
        else
            return true;
    }
    public static boolean Sua_trangthai(int idgh, int sl) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("trangthai",sl);
        long result = MyDB.update("giohang",contentValues,"idgh=?" , new String[]{String.valueOf(idgh)});
        if (result == -1)
            return false;
        else
            return true;
    }
    public static boolean xoa_giohang(int idgh) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        long result = MyDB.delete("giohang","idgh=?" , new String[]{String.valueOf(idgh)});
        if (result == -1)
            return false;
        else
            return true;
    }
}
