package com.example.cuahangbanquanao.DTO;

public class giohang_ {
    int idgh;
    int idtk;
    int idsp;
    int sl;
    int tongtien;
    int trangthai;

    public giohang_() {
    }

    public giohang_(int idgh, int idtk, int idsp, int sl, int tongtien, int trangthai) {
        this.idgh = idgh;
        this.idtk = idtk;
        this.idsp = idsp;
        this.sl = sl;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getIdgh() {
        return idgh;
    }

    public void setIdgh(int idgh) {
        this.idgh = idgh;
    }

    public int getIdtk() {
        return idtk;
    }

    public void setIdtk(int idtk) {
        this.idtk = idtk;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
}
