package com.example.cuahangbanquanao.DTO;

public class danhmuc {
    int iddm;
    String tendm;
    String hinhanh;

    public danhmuc() {
    }

    public danhmuc(int iddm, String tendm, String hinhanh) {
        this.iddm = iddm;
        this.tendm = tendm;
        this.hinhanh = hinhanh;
    }

    public int getIddm() {
        return iddm;
    }

    public void setIddm(int iddm) {
        this.iddm = iddm;
    }

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
