package com.example.cuahangbanquanao.DAO;

import static com.example.cuahangbanquanao.GUI.MainActivity.sqLite_dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.cuahangbanquanao.DTO.Taikhoan;
import com.example.cuahangbanquanao.DTO.danhmuc;
import com.example.cuahangbanquanao.DTO.sanpham;

import java.util.ArrayList;
import java.util.List;

public class San_phamDAO {
    public static Boolean them_sanpham(sanpham sanpham) {
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("iddm", sanpham.getIddm());
        contentValues.put("tensp", sanpham.getTensp());
        contentValues.put("thuonghieu", sanpham.getThuonghieu());
        contentValues.put("chitiet", sanpham.getChitiet());
        contentValues.put("giatien", sanpham.getGiatien());
        contentValues.put("hinhanh", sanpham.getHinhanh());
        long result = MyDB.insert("sanpham", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public static List<sanpham> getall_sanpham() {
        List<sanpham> sanphams = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLite_dao.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * From sanpham", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                sanpham sanpham = new sanpham();
                sanpham.setIdsp(cursor.getInt(0));
                sanpham.setIddm(cursor.getInt(1));
                sanpham.setTensp(cursor.getString(2));
                sanpham.setThuonghieu(cursor.getString(3));
                sanpham.setChitiet(cursor.getString(4));
                sanpham.setGiatien(cursor.getInt(5));
                sanpham.setHinhanh(cursor.getString(6));
                sanphams.add(sanpham);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sanphams;
    }

    public static List<sanpham> timkiem_sp(String tensp) {
        List<sanpham> sanphams = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLite_dao.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * From sanpham where tensp LIKE ?", new String[]{"%" + tensp + "%"});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                sanpham sanpham = new sanpham();
                sanpham.setIdsp(cursor.getInt(0));
                sanpham.setIddm(cursor.getInt(1));
                sanpham.setTensp(cursor.getString(2));
                sanpham.setThuonghieu(cursor.getString(3));
                sanpham.setChitiet(cursor.getString(4));
                sanpham.setGiatien(cursor.getInt(5));
                sanpham.setHinhanh(cursor.getString(6));
                sanphams.add(sanpham);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sanphams;
    }

    public static List<sanpham> danhmuc_sp_(int iddm) {
        List<sanpham> sanphams = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLite_dao.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * From sanpham where iddm=?", new String[]{String.valueOf(iddm)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                sanpham sanpham = new sanpham();
                sanpham.setIdsp(cursor.getInt(0));
                sanpham.setIddm(cursor.getInt(1));
                sanpham.setTensp(cursor.getString(2));
                sanpham.setThuonghieu(cursor.getString(3));
                sanpham.setChitiet(cursor.getString(4));
                sanpham.setGiatien(cursor.getInt(5));
                sanpham.setHinhanh(cursor.getString(6));
                sanphams.add(sanpham);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sanphams;
    }

    public static sanpham get_sp(int idsp) {
        sanpham sanpham = new sanpham();
        SQLiteDatabase MyDB = sqLite_dao.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from sanpham where idsp = ?", new String[]{String.valueOf(idsp)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            sanpham.setIdsp(cursor.getInt(0));
            sanpham.setIddm(cursor.getInt(1));
            sanpham.setTensp(cursor.getString(2));
            sanpham.setThuonghieu(cursor.getString(3));
            sanpham.setChitiet(cursor.getString(4));
            sanpham.setGiatien(cursor.getInt(5));
            sanpham.setHinhanh(cursor.getString(6));
            cursor.close();
            return sanpham;
        }
        return null;
    }
}
