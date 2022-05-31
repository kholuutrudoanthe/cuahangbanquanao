package com.example.cuahangbanquanao.DAO;

import static com.example.cuahangbanquanao.GUI.MainActivity.email_;
import static com.example.cuahangbanquanao.GUI.MainActivity.sqLite_dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.example.cuahangbanquanao.DTO.Taikhoan;

public class Tai_khoanDAO {

    public static Boolean them_taikhoan(Taikhoan tk) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", tk.getEmail());
        contentValues.put("hoten", tk.getHoten());
        contentValues.put("mk", tk.getMk());
        contentValues.put("sdt", tk.getSdt());
        contentValues.put("diachi", tk.getDiachi());
        long result = MyDB.insert("taikhoan", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public static Boolean kiem_tra_tk(String email) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from taikhoan where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public static Boolean kiem_tra_dn(String email, String mk) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from taikhoan where email = ? and mk = ?", new String[]{email, mk});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public static Taikhoan get_thongtin(String email) {
        Taikhoan studen = new Taikhoan();
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from taikhoan where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            studen.setIdtk(cursor.getInt(0));
            studen.setEmail(cursor.getString(1));
            studen.setHoten(cursor.getString(2));
            studen.setMk(cursor.getString(3));
            studen.setSdt(cursor.getString(4));
            studen.setDiachi(cursor.getString(5));
            cursor.close();
            return studen;
        }
        return null;
    }

    public static boolean Sua_taikhoan(String hoten, String sdt, String diachi) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoten", hoten);
        contentValues.put("sdt",sdt);
        contentValues.put("diachi", diachi);
        long result = MyDB.update("taikhoan",contentValues,"email=?" , new String[]{email_});
        if (result == -1)
            return false;
        else
            return true;
    }

}
