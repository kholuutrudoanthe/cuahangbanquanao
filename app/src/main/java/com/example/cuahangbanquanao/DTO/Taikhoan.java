package com.example.cuahangbanquanao.DTO;

public class Taikhoan {
    private int idtk;
    private String email;
    private String hoten;
    private String mk;
    private String sdt;
    private String diachi;

    public Taikhoan() {
    }

    public Taikhoan(int idtk, String email, String hoten, String mk, String sdt, String diachi) {
        this.idtk = idtk;
        this.email = email;
        this.hoten = hoten;
        this.mk = mk;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public int getIdtk() {
        return idtk;
    }

    public void setIdtk(int idtk) {
        this.idtk = idtk;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public String getHoten() {
        return hoten;
    }

    public String getMk() {
        return mk;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiachi() {
        return diachi;
    }
}
