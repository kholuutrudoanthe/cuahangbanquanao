package com.example.cuahangbanquanao.DTO;

public class donhang {
    int iddh,idgh,idtk;
    String loinhan;
    public donhang(int iddh, int idgh, int idtk, String loinhan) {
        this.iddh = iddh;
        this.idgh = idgh;
        this.idtk = idtk;
        this.loinhan = loinhan;
    }

    public donhang() {
    }

    public int getIddh() {
        return iddh;
    }

    public void setIddh(int iddh) {
        this.iddh = iddh;
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

    public String getLoinhan() {
        return loinhan;
    }

    public void setLoinhan(String loinhan) {
        this.loinhan = loinhan;
    }
}
