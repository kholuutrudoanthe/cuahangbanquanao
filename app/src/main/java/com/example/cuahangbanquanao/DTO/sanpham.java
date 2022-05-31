package com.example.cuahangbanquanao.DTO;

public class sanpham {
    int idsp,iddm,giatien;
    String tensp,thuonghieu,chitiet,hinhanh;

    public sanpham() {
    }

    public sanpham(int idsp, int iddm, int giatien, String tensp, String thuonghieu, String chitiet, String hinhanh) {
        this.idsp = idsp;
        this.iddm = iddm;
        this.giatien = giatien;
        this.tensp = tensp;
        this.thuonghieu = thuonghieu;
        this.chitiet = chitiet;
        this.hinhanh = hinhanh;
    }

    public int getIddm() {
        return iddm;
    }

    public void setIddm(int iddm) {
        this.iddm = iddm;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
